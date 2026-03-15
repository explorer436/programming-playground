# Micronaut Application Proof of Concept (POC)

This project demonstrates a simple Micronaut application setup using Gradle and Java. Micronaut is a modern, JVM-based, full-stack framework for building modular, easily testable microservice and serverless applications.

## What is included?
* **A Basic Gradle Project**: Configured for Micronaut with `build.gradle.kts` setup.
* **Entry Point**: `src/main/java/com/example/Application.java` is the bootstrap class.
* **HelloController**: A sample REST controller located at `src/main/java/com/example/HelloController.java` to demonstrate routing and handling HTTP GET requests.

## How to Build the Application
You can compile and build the application using the included Gradle wrapper:

```bash
# On Linux / macOS
./gradlew build

# On Windows
gradlew.bat build
```

## How to Run the Application
Start the application with the `run` task provided by the Gradle plugin:

```bash
# On Linux / macOS
./gradlew run

# On Windows
gradlew.bat run
```

By default, the application will start on port `8080`.

## Testing the Application
Once the application is running, you can test the `HelloController` using `curl` or any web browser:

```bash
curl http://localhost:8080/hello
```
Expected output: `Hello from Micronaut!`

## Key Micronaut Concepts Demonstrated
1. **Dependency Injection**: Micronaut provides fast dependency injection and aspect-oriented programming, with compile-time resolution.
2. **Annotations**: Like Spring Boot, Micronaut utilizes annotations such as `@Controller` and `@Get` to simplify defining routes.
3. **Low Memory Footprint & Fast Startup**: Since Micronaut avoids reflection and does DI at compile-time, applications start quickly and consume very little memory.

## Next Steps
- Add data access using Micronaut Data (`micronaut-data-jdbc` or `micronaut-data-hibernate-jpa`).
- Secure your endpoints with Micronaut Security.
- Check out the full documentation at [micronaut.io](https://micronaut.io/).
