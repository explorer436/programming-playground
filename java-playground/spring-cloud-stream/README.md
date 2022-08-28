### Spring Cloud Stream programming model

To enable connectivity to a message broker for your application, annotate the main class with `@EnableBinding`. The `@EnableBinding` annotation takes one or more interfaces as parameters. You may choose between three interfaces provided by Spring Cloud Stream:

- `Sink`: This is used for marking a service that receives messages from the inbound channel.
- `Source`: This is used for sending messages to the outbound channel.
- `Processor`: This can be used in case you need both an inbound channel and an outbound channel, as it extends the Source and Sink interfaces.

In Spring Cloud Stream nomenclature the implementation responsible for integration with the specific message broker is called `binder`. By default, Spring Cloud Stream provides binder implementations for Kafka and RabbitMQ. It is able to automatically detect and use a binder found on the classpath. Any middleware-specific settings can be overridden through external configuration properties in the form supported by Spring Boot, such as application arguments, environment variables, or just the application.yml file. To include support for RabbitMQ you should add the following dependency to the project.

```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
</dependency>

```

### Scaling up

To scale up our Spring Cloud Stream applications we need to launch additional instances of each microservice. When we do that, a single order is received by all the running instances of every microservice. This is exactly how topic exchanges work – the message sent to the topic is received by all consumers, which are listening on that topic. Fortunately, Spring Cloud Stream is able to solve that problem by providing a solution called consumer group. It is responsible for guaranteeing that only one of the instances is expected to handle a given message if they are placed in a competing consumer relationship.

Configuration of a consumer group mechanism is not very difficult. We just have to set a `group` parameter with the name of the group for the given destination.

Consumer group mechanisms is a concept taken from Apache Kafka, and implemented in Spring Cloud Stream also for RabbitMQ broker, which does not natively support it.

If you set a group name for the selected destination Spring Cloud Stream will create a single binding for all running instances of a given service. The name of the binding will be suffixed with the group name.

### Automated Testing with Spring Cloud Stream

You can easily test your microservice without connecting to a message broker. To achieve it you need to include spring-cloud-stream-test-support to your project dependencies. It contains the TestSupportBinder bean that lets you interact with the bound channels and inspect any messages sent and received by the application.

```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-stream-test-support</artifactId>
  <scope>test</scope>
</dependency>

```
In the test class we need to declare `MessageCollector` bean, which is responsible for receiving messages retained by `TestSupportBinder`. 

### Business scenario for these applications:

The scenario is a cell phone company creating bills for its customers. Each call made by a user has a duration and an amount of data used during the call. As part of the process to generate a bill, the raw call data needs to be converted to a cost for the duration of the call and a cost for the amount of data used.

The three streaming applications are as follows:

- The Source application named UsageDetailSender generates the users' call duration and the amount of data used for each userId and sends a message that contains the UsageDetail object as JSON.
- The Processor application named UsageCostProcessor consumes the UsageDetail and computes the cost of the call and the cost of the data per userId. It sends the UsageCostDetail object as JSON.
- The Sink application named UsageCostLogger consumes the UsageCostDetail object and logs the cost of the call and data.

### Prerequisites

To install and run the RabbitMQ docker image, run the following command:

```
docker run -d --hostname rabbitmq --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:3.7.14-management
```
or
```
docker run -d --name rabbit -p 15672:15672 -p 5672:5672 rabbitmq:management
```

Once installed, you can log in to the RabbitMQ management console on your local machine on http://localhost:15672. You can use the default account username and password: guest and guest.

### Durable Queues

By default, the Spring Cloud Stream consumer application creates an anonymous auto-delete queue. This can result in a message not being stored and forwarded by the producer if the producer application started before the consumer application. Even though the exchange is durable, we need a durable queue to be bound to the exchange for the message to be stored for later consumption. Hence, for guaranteed message delivery, you need a durable queue.

To pre-create durable queues and bind them to the exchange, the producer application should set the following property: `spring.cloud.stream.bindings.<channelName>.producer.requiredGroups`

The requiredGroups property accepts a comma-separated list of groups to which the producer must ensure message delivery. When this property is set, a durable queue is created by using the `<exchange>.<requiredGroup>` format.

### Message flow

When you deploy these three applications (UsageDetailSender, UsageCostProcessor, and UsageCostLogger), the flow of message is as follows:

`UsageDetailSender -> UsageCostProcessor -> UsageCostLogger`

The `UsageDetailSender` source application's output is connected to the `UsageCostProcessor` processor application's input. The `UsageCostProcessor` application's output is connected to the `UsageCostLogger` sink application's input.

When these applications run, the RabbitMQ binder binds the applications' output and input boundaries into the corresponding exchanges and queues at RabbitMQ message broker.

### Running the applications:

Start each of them by using `mvn spring-boot:run`. The port number to be used by each of them is specified in their application.yml file.

### Apache Kafka-binder documentation

There are many configuration options that you can choose to extend/override to achieve the desired runtime behavior when using Apache Kafka as the message broker. The Apache Kafka-specific binder configuration properties are listed in [Apache Kafka-binder documentation](https://cloud.spring.io/spring-cloud-static/spring-cloud-stream-binder-kafka/current/reference/html/spring-cloud-stream-binder-kafka.html#_configuration_options)

