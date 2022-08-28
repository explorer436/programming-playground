# Stack And Resources

## Terminology and resources
* Typescript
* AWS
* API Gateway
   - An endpoint to call services inside AWS
   - https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-rest-api.html
   - Private Gateway https://forge.lmig.com/wiki/display/CPCA/Private+Endpoints+for+API+Gateway
* Lambda
   - Small functions of code 
   - Can be invoked by other AWS services
   - Can be triggered by events and triggers
* CDK (Cloud Development Kit)
   - https://docs.aws.amazon.com/cdk/api/latest/docs/aws-construct-library.html
* SAM (Serverless Application Model)
   - CLI tooling to work locally
* SAML (Security Assertion Markup Language)
   - https://docs.aws.amazon.com/singlesignon/latest/userguide/samlfederationconcept.html
   - https://forge.lmig.com/wiki/display/ETSPC/SAML+API+Key+Retriever+Utility
* IAM (Identity Access Management)
   - Think of this like an LDAP. Manages Users, Roles and Groups.

## Dynamically Getting AWS Environment Info Using CustomResources
* CustomResources are used in the Stack to dynamically get the VPC for each environment.

## Debugging the Stack
* `cdk synth` will generate the CFT locally

## How we deploy to Multiple Environments

By default, the accelerator project that this application was generated from creates an application in AWS with the same name as the name of the application. In AWS terms, all of the components that are created, Lambdas, API Gateway etc, are stored under the umbrella of the application. There can only be one uniquely named application per region per account. So by default if the team wanted to deploy to the Development region (Note our Bamboo setup only support a Sandbox, Development and/or Production region) we could only deploy one stack. What we found was if we tried to setup multiple environments in the same classification, we would simply update and not create a new environment. This limited us to the number of environments we could create.

As a team we decided we would want to have Development, Test and Performance deploys. In order to do this we had to make a change to the unique name that is auto generated for us by the Accelerator. 

The stack constructor is what defines the application name. In order to deploy the 3 environments into one region we had to change the name that was being generated. In the code `bin/proof-of-insurance-cdk-app.ts` the following line was modified from 

```javascript
new ProofOfInsuranceCDKStack(app, StackConfiguration.stackName);
```

to 

```javascript
new ProofOfInsuranceCDKStack(app, StackConfiguration.appName);
```

The stack configuration class was also changed to add a new application name field. This property consists of the application name plus the environment name given in Bamboo (not to be confused with the classification in bamboo, which is Sandbox, Development or Production).

```javascript
"appName": process.env.stack_name || "employee-application" + "-" + (process.env.bamboo_forge_deployment_key || "sandbox"),
```

With this change, the application name in AWS will now be, for example: `employee-application-performance`

Now when a new environment is stood up in the Bamboo Pipeline we get a unique application name for it.

Reference Documents on how the AWS Stack works
* https://docs.aws.amazon.com/cdk/api/latest/docs/@aws-cdk_core.Stack.html
* https://docs.aws.amazon.com/cdk/latest/guide/stacks.html

## How local Development works

AWS released a tool called SAM (Serverless Application Model) which works very similar to the CDK. SAM also includes tooling to work locally and simulate an AWS environment.

For SAM to work, Docker is required. When you initialize a lambda for the first time, SAM pulls down a docker container that will simulate a deployed instance of the lambda. SAM utilizes a generated `template.yml` file which contains the definition of the stack. 

Breaking down the main testing commands, the team utilizes `npm start` `npm prestart` and `npm watch` for local testing

`npm start`
This starts a local SAM server. The SAM server exposes API Gateway definitions. In turn, exposing the lambdas associated to them. The start method utilizes the `start-api` mechanics of SAM. This is defined as

> Sets up a local endpoint you can use to test your API. Supports hot-reloading so you don't need to restart this service when you make changes to your function.

Which means that any changes to the build/output folder will automatically be mapped and deployed to the running service. You do not have to start/stop the server after each change. This is achieved by the SAM docker container exposing a volume mapping `/var/task` (internal) to the applications output folder `dist/functions`. 

One thing missing from testing locally is that Lambda authorization is not supported at this time. This allows you to bypass authorization checks when testing locally. This also means that you can not test Authorization lambdas locally by this command. You will want to look at a combination of `npm prestart` and `sam local invoke` commands if you need to test Lambdas not exposed by API gateway.

`npm run prestart`
This command is the workhorse of this set of commands. Prestart runs the webpack build and then runs a synthesis of the stack in order to generate the necessary cloud formation template that SAM needs to run. 

The most important flag in the prestart function is `--no-staging`. This allows CDK and SAM to talk the same language. Without this flag the root folder would be flooded with `asset.**` folders and SAM would not startup properly. 

When `start` is run, `prestart` is automatically run before it. As npm wraps all of its main commands with `pre` and `post` commands. 

Utilize prestart individually when you want to test a lambda without api gateway

`npm run watch`
Pairs really nicely with start. After starting the SAM service, run watch. Watch will auto build your lambda functions whenever there are changes and since they are auto mapped into the docker container you do not need to rebuild or restart any services.

The SAM service and this watch will need to be shut down and restarted whenever there are changes made to the stack.

# Troubleshooting

### API Gateway "Forbidden" after Policy changes

The team ran into an issue where we had created a Lambda with API gateway fronting the function. The team made the API gateway private, but were tweaking the security policy for the VPC. What we found was that making changes to the policy statement attached to the API gateway did not make the changes we expected.

Running `cdk synth` and `cdk diff` we would see our changes. When deployed to AWS using `cdk deploy` (or via Bamboo Pipeline) we would also see the changes listed in API Gateway under the Resource Policy. But the changes never seemed to take effect.

It was found in another document that any changes to a Policy Document/Statement do not initialize a new deployment. Even though the new configuration can be seen in the AWS console, they still have to be deployed manually.

As reference here is a [link to the document](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-resource-policies-create-attach.html) and and exert 
> If you update the resource policy after the API is created, you'll need to deploy the API to propagate the changes after you've attached the updated policy. Updating or saving the policy alone won't change the runtime behavior of the API.


To do a manual deployment, go to the AWS console -> pick api gateway -> find your resource -> actions -> Deploy API

### API Gateway is responding with 403 "Missing Authentication Token"

This error occurs when you are attempting to hit an endpoint that has not been exposed.
To resolve this issue, perform the following checks
* Are you using the correct VPC endpoint?
* Is the Host value set properly
* Check if you are calling a GET/POST/PUT
* Check the URL you are using
* Ensure the proper endpoints are exposed in the Policy Document/Statement

### Deployed a stack to AWS - How do I delete it

If it is just the AWS Stack that needs to be deleted it can be done via the cloud forge console. 

*Warning* :: If other resources like repositories and Bamboo pipelines need to be deleted, this is not the right guide.

   * Open Public Cloud 
   * From the top menu choose AWS > Accounts
   * Pick the account for your stack. This is the account used to deploy the stack and can be found in the bamboo deploy logs.
   * Click on the Resources tab
   * Under management & Governance: choose CloudFormation Stacks
   * Find your stack, use the filter in the top right to find your stack

   * Click the stack for the application you want to delete
   * On the main screen you will see a button to delete the stack. 
   * Click the button and follow the confirmation prompts

As the stack deletes, you can follow the log to see the status of the cleanup. The log can be found on the same page as the delete button. Scroll down on the page and you should see a list of resources and their current state. 

### Deploy Takes a long time and there are delete failures

When a delete is in progress it may take 5-15 minutes before it errors out. You will see a `DELETE_IN_PROGRESS` which seems to hang while the deployment is occurring. The message in the log may look similar to 

`DELETE_FAILED | AWS::IAM::Role | helloServiceRole353607D3 Cannot delete entity, must detach all policies first.`

or 

`DELETE_FAILED | AWS::EC2::SecurityGroup | defaultRouteSecurityGroupC8F16279 resource sg-0e5f515e48512e240 has a dependent object`

The reason these deletes fail is due to Lambdas using VPCs. When a lambda is removed from a VPC or the name of the Lambda changes, so does the roles and security groups that are generated. 

When a lambda is put in a VPC it creates a network interface. When the Lambda is removed from the VPC, the network interface is not deleted right away. It takes up to 4 hours for AWS to remove the network interface. This is a known issue in AWS.

Because the network interface takes time to delete the security group, which it is dependent on, can not be deleted. This causes the build to hold up.

Though the timing is poor for these deployments, there should be no impacts to your application. In the background after your deployment is compete, AWS seems to quietly clean up these resources for you after the network-interface is cleaned up. After the cleanup is completed by AWS, future deploys should be much faster.

To avoid this issue, use caution when removing Lambdas from VPCs or when changing the ID of any Lambda

### Testing Locally with SAM - Gives error after fetching container

If you are on windows, you may not have setup docker correctly. Make sure to read the setup guide and pay attention to the "use linux container" and "shared drive" options. Without these turned on you will continue to get mount issues with the container as the container won't be able to map your applications output folder to the internal docker volume.

The error you will get will be something like "can not mount to /var/task"

[more information here](https://github.com/awslabs/aws-sam-cli/issues/1126)

### Analyze the Lambda Stack Size

Size and memory have a major impact on the performance of a Lambda. To perform an analysis on the bundle sizes run the following commands

```
npm install --g webpack-bundle-analyzer

npx webpack --profile --json > stats.json
npx webpack-bundle-analyzer stats.json

```

Running the 3rd command will pop open a browser window showing a breakdown of all the node modules and package sizes

Details about the webpack analyzer can be found here https://github.com/webpack-contrib/webpack-bundle-analyzer
