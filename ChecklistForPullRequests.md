This is a checklist that could be helpful before submitting a PR:
Pull from master
Run yarn lint
Run yarn test
In test cases, if there is a chance to use tables, use tables instead of writing individual test cases.
Test API locally
Push your changes
Deploy your branch to develop to make sure it works as expected
If there is a new service integration, is the documentation updated? Are the manifest files updated?
Is there common code that can be put in a library as opposed to including it in the application itself?
Wherever possible, if things need to be added to constructors, put them in constructors - I'd ask myself: Should I re-use the same DependentService instance for all requests from the CurrentClass? Or do I need a new one for each request?
Do not put process variables in test classes. Mock them.
Passing parameters to constructors is a good idea instead of passing parameters to individual functions. Especially, if the methods use state and if they are not pure.
Update the Jira ticket with the description about the work that is being done on the task. This will prevent having to explain each and every change to each and every person reviewing the pull request.
Wherever necessary, redact the sensitive data like passwords, tokens from printing on the logs.
Request PR