# CST-339 Lab 1: First Professional Spring Boot API

A Spring Boot REST API for managing `Product` resources, built incrementally across a series of feature branches to demonstrate a layered `Controller → Service → Repository → Database` architecture.

## Project

- **Location:** `lab1-api/`
- **Stack:** Java 21, Spring Boot 4.x, Maven
- **Dependencies:** Spring Web, Spring Data JPA, PostgreSQL Driver, Validation, Spring Boot DevTools

## Running the app

```
cd lab1-api
./mvnw spring-boot:run
```

The app starts on `http://localhost:8080`.

## Branch 1 — Default Spring Boot Application

**Checkpoint:** Application runs; `localhost:8080` responds; understand why no route exists yet.

Hitting `http://localhost:8080/` at this stage returns a `404 Not Found`. This is expected: Tomcat and the Spring application context start up successfully, but no `@Controller`/`@RestController` has been defined yet, so Spring has no handler mapped to the `/` route. (A browser would show Spring Boot's Whitelabel Error Page; this API-oriented project instead returns the same 404 as a JSON error body.) Subsequent branches add the first mapped endpoint.
