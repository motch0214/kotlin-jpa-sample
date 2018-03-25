# Kotlin JPA sample

Sample of JPA (hibernate and spring) with kotlin.

## Domain Layer

This is the domain in the context of DDD.

It depends on `javax` interfaces only.


## Application Layer

With the Spring Framework, spring jpa repositories and configurations for IoC (DI) are defined in this layer.


## Test Layer

There are test classes for the domain layer by using test database defined in `persistence.xml`.
