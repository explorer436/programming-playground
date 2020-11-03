This is a checklist that could be helpful before submitting a PR:
*	Update the Jira ticket with the description about the work that is being done on the task. This will prevent having to explain each and every change to each and every person reviewing the pull request.
*	Pull from master
*	Run yarn lint and yarn test - to make sure that everything looks good before you start making changes locally.
*	In test cases, if there is a chance to use tables, use tables instead of writing individual test cases.
*  e.g. it.each with jest. This is also possible with junit.
*	Test API locally for end-to-end integration
*  Make changes and test everything again - unit tests, integration tests, linters, etc.
*	Push your changes
*	Deploy your branch to develop to make sure it works as expected
*	If there is a new service integration, is the documentation updated? Update the README file if necessary. Are the manifest files updated?
*	Is there common code that can be put in a library as opposed to including it in the application itself?
*	Wherever possible, if things need to be added to constructors, put them in constructors - I'd ask myself: Should I re-use the same DependentService instance for all requests from the CurrentClass? Or do I need a new one for each request?
*	Do not put process variables or write code for process variables in test classes. Mock them.
*	Passing parameters to constructors is a good idea instead of passing parameters to individual functions. Especially, if the methods use state and if they are not pure.
*  Make sure each layer like controller layer, service layer, etc. is doing what it is expected to do. Pay attention to separation of concerns. Things like validation should not seep into the deeper layers of the application. They should be handled as early as possible. Preferably, in the controller layer or in the service layer.
*	Wherever necessary, redact the sensitive data like passwords, tokens from printing on the logs.
*	Create pull request and send it out for review.
