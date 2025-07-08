plugins {
    id("buildlogic.java-conventions")
    id("io.freefair.lombok") version "8.14"
}

dependencies {
    // https://mvnrepository.com/artifact/org.apache.commons/commons-collections4

    implementation(project(":my-utilities"))
    implementation(project(":algorithms-and-datastructures"))
    implementation("org.apache.commons:commons-collections4:4.5.0")

    // JUnit Jupiter API for writing tests
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.0")
    // JUnit Jupiter Engine for running tests
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.0")
    // JUnit Platform Launcher (for running tests, often implicitly added by Gradle with test suites)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.11.0")
}

tasks.test {
    useJUnitPlatform {
        version = "5.8.2"
    }
}

description = "searching-and-sorting"

