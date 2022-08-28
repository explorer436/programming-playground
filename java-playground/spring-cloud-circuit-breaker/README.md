* Overview

A microservice application that uses the Circuit Breaker pattern to gracefully degrade functionality when a method call fails. Use of the Circuit Breaker pattern can allow a microservice to continue operating when a related service fails, preventing the failure from cascading and giving the failing service time to recover.

* Spring cloud circuit breaker

Spring Cloud’s Circuit Breaker library provides an implementation of the Circuit Breaker pattern: when we wrap a method call in a circuit breaker, Spring Cloud Circuit Breaker watches for failing calls to that method, and if failures build up to a threshold, Spring Cloud Circuit Breaker opens the circuit so that subsequent calls automatically fail. While the circuit is open, Spring Cloud Circuit Breaker redirects calls to the method, and they’re passed on to our specified fallback method.

Spring Cloud Circuit Breaker supports many different circuit breaker implementations including, Resilience4J, Hystrix, Sentinal, and Spring Retry. In this guide we will use the Resilience4J implementation. To use this implementation we just need to add `spring-cloud-starter-circuitbreaker-reactor-resilience4j` to our application’s classpath.

```
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-circuitbreaker-reactor-resilience4j</artifactId>
    </dependency>

```

Spring Cloud Circuit Breaker provides an interface called `ReactiveCircuitBreakerFactory` which we can use to create new circuit breakers for our application (see BookService.java). An implementation of this interface will be auto-configured based on the starter that is on your application’s classpath. `BookService.java` is a service that uses this interface to make API calls to the Book-recommendation application.

The `ReactiveCircuitBreakerFactory` has a single method called `create` (see BookService.java) we can use to create new circuit breakers. Once we have our circuit breaker all we have to do is call run. Run takes a `Mono` or `Flux` and an optional `Function`. The optional Function parameter acts as our fallback if anything goes wrong. In our sample here the fallback will just return a Mono containing the String `Cloud Native Java (O’Reilly)`.

* Reference

  https://spring.io/guides/gs/cloud-circuit-breaker/
