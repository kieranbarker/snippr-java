# Snippr (Java)

An API for managing code snippets.

This project was [bootstrapped with Spring Initializr](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.5.3&packaging=jar&jvmVersion=24&groupId=codes.barker&artifactId=snippr&name=snippr&description=An%20API%20for%20managing%20code%20snippets&packageName=codes.barker.snippr&dependencies=web,h2,data-jpa,security). It is based loosely on the [Building REST services with Spring](https://spring.io/guides/tutorials/rest) guide.

## Dependencies

### Spring Web

Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.

### H2 Database

Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.

### Spring Data JPA

Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.

### Spring Security

Highly customizable authentication and access-control framework for Spring applications.

## Classes, Interfaces, and Exceptions

### SnipprApplication (Class)

The `SnipprApplication` class is the entry point to our application.

### Snippet (Class)

The `Snippet` class represents a code snippet. It is annotated with [`@Entity`](https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/entity). This indicates that instances of this class represent rows in a database table.

### SnippetRepository (Interface)

The `SnippetRepository` interface extends the [`JpaRepository`](https://docs.spring.io/spring-data/jpa/reference/api/java/org/springframework/data/jpa/repository/JpaRepository.html) interface. This gives us access to several methods including [`save(S entity)`](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html#save(S)), [`findAll()`](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/ListCrudRepository.html#findAll()), and [`findById(ID id)`](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html#findById(ID)).

### LoadDatabase (Class)

The `LoadDatabase` class populates the database with some initial data when the application runs.

### SnippetController (Class)

The `SnippetController` class is where we define our routes. The term "controller" comes from the [model–view–controller](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) (MVC) architectural pattern. We use annotations like [`@PostMapping`](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PostMapping.html) and [`@GetMapping`](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html) to map specific [HTTP request methods](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Methods) to our routes.

### SnippetNotFoundException (Exception)

We throw a `SnippetNotFoundException` when a snippet cannot be found.

### SnippetNotFoundAdvice (Class)

The `SnippetNotFoundAdvice` class kicks in when we throw a `SnippetNotFoundException`. It tells Spring to send the error as the body of a [404 Not Found](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status/404) response.

### Encryptor (Class)

The `Encryptor` class uses the [Spring Security Crypto Module](https://docs.spring.io/spring-security/reference/features/integrations/cryptography.html) to handle encryption and decryption.

## Accessing the database

To access the in-memory database, open the [H2 Console](http://localhost:8080/h2-console) and use the following credentials. These are defined in the `application.properties` file. 

- **JDBC URL:** jdbc:h2:mem:testdb
- **Username:** sa
- **Password:** password

Once logged in, you can run an SQL query like `SELECT * FROM snippets;` to see what's in the database.