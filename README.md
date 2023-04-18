# MariaDB - JPA, JDBC, & Spring Boot

**Table of contents**

- [MariaDB - JPA, JDBC, \& Spring Boot](#mariadb---jpa-jdbc--spring-boot)
  - [Introduction](#introduction)
    - [Database Schema](#database-schema)
  - [How to install](#how-to-install)
  - [How to use](#how-to-use)
    - [AppJPA in the terminal](#appjpa-in-the-terminal)
    - [AppSpringBoot in Postman](#appspringboot-in-postman)
  - [Testing](#testing)

## Introduction

This is an asignment made for the Databases assignature. We were asked to create a project of our choice using and combining the knowledge we adquired about [Plain and Pool Connection with JDBC](https://mariadb.com/resources/blog/how-to-connect-java-applications-to-mariadb-using-jdbc/), and [connection with JPA/Hibernate](https://dzone.com/articles/getting-started-with-jpahibernate) to a MariaDB database.

After thinking about it, we decided to try and create an API REST using Java, JPA, and Spring Boot. We hoped to use the logic we made with JPA to access the database (as it used also the Pool Connection of JDBC, which is better than a simple Plain Connection), but when implementing the Spring Boot framework to construct the API REST, we realized that it was not possible, and ended up using the JPA version that already came with Spring Boot instead, which we found it was much more easy and intuive than the raw use of JPA with the use of the Hibernate ORM.

In the end, and to preserve our work with JPA, we ended up with two different `App` files: `AppJPA`, which works with the pure version of JPA/Hibernate; and `AppSpringBoot`, which initiates the Spring Boot API REST using the JPA version of Spring Boot. We'll talk about how each of them work in more detail below.

Finally, a mention of honor to [JLDJR2481](https://github.com/JLDJR2481) for the amazing work he did to make Spring Boot work. Good work, partner!

### Database Schema

## How to install

## How to use

### AppJPA in the terminal

### AppSpringBoot in Postman

[![Run in Postman](https://run.pstmn.io/button.svg)](https://god.gw.postman.com/run-collection/26400016-52e5e2b9-d189-47fb-b0c7-dad85356eaa0?action=collection%2Ffork&collection-url=entityId%3D26400016-52e5e2b9-d189-47fb-b0c7-dad85356eaa0%26entityType%3Dcollection%26workspaceId%3Db6e3eeac-770e-4cce-8f61-a31866271e87)

## Testing
