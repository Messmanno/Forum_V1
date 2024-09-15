# Gestion d'un Forum - Spring Boot

## Description

Ce projet est une application de *gestion de forum* permettant aux utilisateurs d'interagir sur différents *sujets* à travers des *messages. Il y'a possibilité de créer des forums, des sujets, et des messages. L'application expose également des **API REST* pour la gestion des données.

## Fonctionnalités

- *Gestion des forums* : Créer et lister des forums, obtenir les détails d'un forum.
- *Gestion des sujets* : Chaque forum contient des sujets créés .
- *Gestion des messages* : Répondre aux sujets par des messages.
- *API REST* : Toutes les entités (Forum, Sujet, Message) sont accessibles via des endpoints RESTful.

## Structure du projet

Les principales entités du projet sont :
- *Bas'e sur l'achitecture en couche*

1. *Forum* : Représente un espace de discussion contenant plusieurs sujets.
2. *Subject (Sujet)* : Un sujet appartient à un forum et contient des messages.
3. *Message* : Un message est la réponse d'un utilisateur à un sujet.

## Technologies utilisées

- *Java 17*
- *Spring Boot 3.x*
- *Spring Data JPA* pour l'accès aux données.
- *Hibernate* pour la gestion ORM.
- *PostgreSQL* pour la base de données.
- *Maven* pour la gestion des dépendances.
- *Lombok* pour simplifier le code (réduire les getters/setters).
- *PostMan* documentation de l'API.


## Prérequis

- *Java 17+*
- *Maven*
- *PostgreSQL*

## Installation

- *Clone project on your local machine*
  bash
  git clone https://github.com/attoubo/Forum-V1.git


- *Got to project directory*
  bash
  cd forum-V1


- *Setting up your application.proprieties file*
  properties
  spring.datasource.url=jdbc:postgresql://localhost:5433/(yourdatabase_name)
  spring.datasource.username=(your username)
  spring.datasource.password=(your password)
  spring.jpa.hibernate.ddl-auto=create



- *Command for run project*
  bash
  mvn clean install
  mvn spring-boot:run


5. L'api sera accessible à l'adresse [http://localhost:8080/api](http://localhost:8080/api).
6. # Gestion d'un Forum - Spring Boot

## Description

Ce projet est une application de *gestion de forum* permettant aux utilisateurs d'interagir sur différents *sujets* à travers des *messages. Il y'a possibilité de créer des forums, des sujets, et des messages. L'application expose également des **API REST* pour la gestion des données.

## Fonctionnalités

- *Gestion des forums* : Créer et lister des forums, obtenir les détails d'un forum.
- *Gestion des sujets* : Chaque forum contient des sujets créés .
- *Gestion des messages* : Répondre aux sujets par des messages.
- *API REST* : Toutes les entités (Forum, Sujet, Message) sont accessibles via des endpoints RESTful.

## Structure du projet

Les principales entités du projet sont :
- *Bas'e sur l'achitecture en couche*

1. *Forum* : Représente un espace de discussion contenant plusieurs sujets.
2. *Subject (Sujet)* : Un sujet appartient à un forum et contient des messages.
3. *Message* : Un message est la réponse d'un utilisateur à un sujet.

## Technologies utilisées

- *Java 17*
- *Spring Boot 3.x*
- *Spring Data JPA* pour l'accès aux données.
- *Hibernate* pour la gestion ORM.
- *PostgreSQL* pour la base de données.
- *Maven* pour la gestion des dépendances.
- *Lombok* pour simplifier le code (réduire les getters/setters).
- *PostMan* documentation de l'API.


## Prérequis

- *Java 17+*
- *Maven*
- *PostgreSQL*

## Installation

- *Clone project on your local machine*
  bash
  git clone https://github.com/attoubo/Forum-V1.git


- *Got to project directory*
  bash
  cd forum-V1


- *Setting up your application.proprieties file*
  properties
  spring.datasource.url=jdbc:postgresql://localhost:5433/(yourdatabase_name)
  spring.datasource.username=(your username)
  spring.datasource.password=(your password)
  spring.jpa.hibernate.ddl-auto=create



- *Command for run project*
  bash
  mvn clean install
  mvn spring-boot:run


5. L'api sera accessible à l'adresse [http://localhost:8080/api](http://localhost:8080/api).
6. DOCUMENTATION de l'api via le lien https://documenter.getpostman.com/view/37820956/2sAXqp83uX