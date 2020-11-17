This is a checklist that could be helpful before submitting a PR:

 1. Update the Jira ticket with the description about the work that is being done on the task. If the scope or the direction of the task changes mid-way through the implementation process, make sure that the Jira ticket is updated. This will serve as good documentation and help avoid having to answer multiple people on multiple occasions. This will prevent having to explain each and every change to each and every person reviewing the pull request. For anyone looking to find out why a change was made, the Jira ticket will have all the answers.
 2. Pull from master
 3. Run the linters and unit tests before starting to make any changes - to make sure that everything looks good before you start making changes locally. yarn lint and yarn test
 4. In test cases, if there is a chance to use tables, use tables instead of writing individual test cases. e.g. it.each with jest. This is also possible with junit.
 5. Test API locally for end-to-end integration
 6. Make changes and test everything again - unit tests, integration tests, linters, etc.
 7. Push your changes
 8. Deploy your branch to develop to make sure it works as expected
 9. If there is a new service integration, is the documentation updated? Update the README file if necessary. Are the manifest files updated?
10. Is there common code that can be put in a library as opposed to including it in the application itself?
11. Wherever possible, if things need to be added to constructors, put them in constructors - I'd ask myself: Should I re-use the same DependentService instance for all requests from the CurrentClass? Or do I need a new one for each request?
12. Do not put process variables or write code for process variables in test classes. Instead, mock them.
13. Passing parameters to constructors is a good idea instead of passing parameters to individual functions. Especially, if the methods use state and if they are not pure.
14. Make sure each layer like controller layer, service layer, etc. is doing what it is expected to do. Pay attention to separation of concerns. Things like validation should not seep into the deeper layers of the application. They should be handled as early as possible. Preferably, in the controller layer or in the service layer.
15. Wherever necessary, redact the sensitive data like passwords, tokens from printing on the logs.
16. In javascript, verify the use of backticks can be replaced by single quotes.
17. Go through the javadocs or descriptions for each single method and test case and verify if they are describing the method or test case appropriately.
18. For javascript tests, make sure that there is a class level description at the top.
19. Create pull request and send it out for review.
