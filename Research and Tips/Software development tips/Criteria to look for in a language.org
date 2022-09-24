List of things to consider when looking to learn a new programming language : 

This will give an overview of the practicality of the language.

1. Implement Binary tree search or any other algorithm in the language
1. Implement a RESTful service (producer) and a client for a REST API. There are many open REST services that are available for public consumption.
1. Implement a soap service producer and a soap service client (preferably, using vanilla approach). If it is absolutely necessary to use libraries, be mindful of the impacts of using the libraries. e.g. springboot for java, strongsoap for node.js, etc.
1. Implement using custom ssl certificates. See the differences in the ways this is handled by various languages. This process is handled graciously in some languages and it is a painful process in other languages.
1. Implement parallel service calls (both RESTful and Soap service calls)
1. Verify concurrency
1. Implement a few database operations - RDBMS and NoSQL.
1. How good is the cloud support for these languages? For example, CloudFoundry offers good (in some cases, custom support) support for Java and NodeJS based applications. What happens if we want to use other languages for applications?
1. How good is the support in other platforms like AWS and Azure and GCP?

------------

Looking at the simplicity offered by NodeJS + Javascript approach, working with Java (especially, springboot based applications) does not seem very straight-forward. Setting up the application seems daunting. Once everything gets going, working with the application is fairly staight-forward. But setting it up seems difficult. As other people mention many times, the springboot magic is a blessing and a curse at the same time. When it works, its great but when it doesn't, it is difficult to understand why it is not (or why it is) working. For someone looking for reasons not to use Java, this use case is a good example. Javascript is a horrible language, but the simplicity it seems to offer may be worth the effort of going through developing an application with a horrible dynamic typing language.

------------

Look into the following :

1. SmallTalk programming language.
1. Web services (soap and rest services) using Haskell.
1. How hard it easy is it to write a web service produce (soap and rest) using vanilla java?

------------

Haskell + Java : 
	https://github.com/Frege/frege
	https://github.com/Frege/frege/wiki/Getting-Started

------------