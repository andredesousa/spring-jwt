# Spring Security and JSON Web Tokens

Sometimes it is necessary to check if an authenticated user has a specific role.
This can be useful to enable or disable particular features in our applications.

## Overview

[Spring Security](https://spring.io/projects/spring-security) makes it more easy to build these types of rules using the roles and privileges.
We can assign roles and privileges to the user during registration / creation process.

First your user class need to implements `UserDetails` and then you should implement `getAuthorities()` method according to your `Role` and `Authority` structure.
Spring Security basically checks what `getAuthority()` method returns:

- If returned value prefixed with `ROLE_` like `ROLE_ADMIN` it will be processed as Role.
- If it does not prefixed with `ROLE_` it will be processed as Authority.

You can use class or method annotation for checking authority and role like following example:

```java
@PreAuthorize("hasRole('ROLE_ADMIN') and hasAuthority('READ')") 
```

This project uses a [PostgreSQL](https://www.postgresql.org/) database for data persistence.
In local development, you need to provide a connection to a `PostgreSQL` instance.

You can use the following docker command:

```bash
docker run -d -p 5432:5432 -e POSTGRES_DB=spring -e POSTGRES_USER=root -e POSTGRES_PASSWORD=secret postgres
```

The project supports database migrations via [Flyway](https://flywaydb.org/) and it uses [Lombok](https://projectlombok.org/).

## Project structure

This project was generated with [Spring Initializr](https://start.spring.io/).
All of the app's code goes in a folder named `src/main`.
The **unit tests** and **integration tests** are in the `src/test` and `src/integrationTest` folders.
Static files are placed in `src/main/resources` folder.

## Available gradle tasks

The tasks in [build.gradle](build.gradle) file were built with simplicity in mind to automate as much repetitive tasks as possible and help developers focus on what really matters.

The next tasks should be executed in a console inside the root directory:

- `./gradlew tasks` - Displays the tasks runnable from root project 'app'.
- `./gradlew bootRun` - Runs this project as a Spring Boot application.
- `./gradlew check` - Runs all checks.
- `./gradlew test` - Runs the unit tests.
- `./gradlew integrationTest` - Run the integration tests.
- `./gradlew clean` - Deletes the build directory.
- `./gradlew build` - Assembles and tests this project.
- `./gradlew help` - Displays a help message.

For more details, read the [Command-Line Interface](https://docs.gradle.org/current/userguide/command_line_interface.html) documentation in the [Gradle User Manual](https://docs.gradle.org/current/userguide/userguide.html).

## Authentication and authorization

Authentication is an essential part of most applications. There are many different approaches and strategies to handle authentication.

[JSON Web Tokens](https://jwt.io/) is an authentication standard that works by generating and signing tokens, passing them around between the client-side and server-side applications, passed around via query strings, authorization headers, or other mediums.
Having such a valid and non-expired token, extracted from an HTTP Request, signals the fact that the user is authenticated and is allowed to access protected resources.
The default user is `admin` and the password is `admin`. Use for development only.

Authorization refers to the process that determines what a user is able to do.
For example, an administrative user is allowed to create, edit, and delete posts.
A non-administrative user is only authorized to read the posts.

You can see these configurations by opening the [WebSecurity.java](src/main/java/app/config/WebSecurity.java) file.

## Running unit tests

Unit tests are responsible for testing of individual methods or classes by supplying input and making sure the output is as expected.

Use `./gradlew test` to execute the unit tests via [JUnit 5](https://junit.org/junit5/), [Mockito](https://site.mockito.org/) and [AssertJ](https://assertj.github.io/doc/).
Use `./gradlew test -t` to keep executing unit tests in real time while watching for file changes in the background.
You can see the HTML report opening the [index.html](build/reports/tests/test/index.html) file in your web browser.

It's a common requirement to run subsets of a test suite, such as when you're fixing a bug or developing a new test case.
Gradle provides different mechanisms.
For example, the following command lines run either all or exactly one of the tests in the `SomeTestClass` test case:

```bash
./gradlew test --tests SomeTestClass
```

For more details, you can see the [Test filtering](https://docs.gradle.org/current/userguide/java_testing.html#test_filtering) section of the Gradle documentation.

This project uses [JaCoCo](https://www.eclemma.org/jacoco/) which provides code coverage metrics for Java.
The minimum code coverage is set to 80%.
You can see the HTML coverage report opening the [index.html](build/reports/jacoco/test/html/index.html) file in your web browser.

## Running integration tests

Integration tests determine if independently developed units of software work correctly when they are connected to each other.

Use `./gradlew integrationTest` to execute the integration tests via [JUnit 5](https://junit.org/junit5/), [Mockito](https://site.mockito.org/) and [AssertJ](https://assertj.github.io/doc/).
Use `./gradlew integrationTest -t` to keep executing your tests while watching for file changes in the background.
You can see the HTML report opening the [index.html](build/reports/tests/integrationTest/index.html) file in your web browser.

Like unit tests, you can also run subsets of a test suite.
See the [Test filtering](https://docs.gradle.org/current/userguide/java_testing.html#test_filtering) section of the Gradle documentation.

## Debugging

You can debug the source code, add breakpoints, inspect variables and view the application's call stack.
Also, you can use the IDE for debugging the source code, unit and integration tests.
You can customize the [log verbosity](https://docs.gradle.org/current/userguide/logging.html#logging) of gradle tasks using the `-i` or `--info` flag.

This project includes [Swagger](https://swagger.io/). To get a visual representation of the interface and send requests for testing purposes go to <http://localhost:8080/swagger-ui.html>.

## Reference documentation

For further reference, please consider the following articles:

- [Official Gradle documentation](https://docs.gradle.org)
- [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.5/gradle-plugin/reference/html/)
- [Spring Security – Roles and Privileges](https://www.baeldung.com/role-and-privilege-for-spring-security-registration)
- [Granted Authority Versus Role in Spring](https://www.baeldung.com/spring-security-granted-authority-vs-role)
- [Spring Security with JWT for REST API](https://www.toptal.com/spring/spring-security-tutorial)
- [Database Migrations with Flyway](https://www.baeldung.com/database-migrations-with-flyway)
- [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.5.5/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
- [Testing with Spring Boot and @SpringBootTest](https://reflectoring.io/spring-boot-test/)
- [Spring Data JPA Persistence Layer Tests With @DataJpaTest](https://rieckpil.de/test-your-spring-boot-jpa-persistence-layer-with-datajpatest/)
- [Testing JPA Queries with Spring Boot and @DataJpaTest](https://reflectoring.io/spring-boot-data-jpa-test/)
