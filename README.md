<a href="https://www.flaticon.com/free-icon/recipe_3565418">
  <img src="https://cdn-icons-png.flaticon.com/512/3565/3565418.png" align="right"
     alt="Recipe Image" height="300">
</a>

# RecipesEngine 
[![Activity](https://img.shields.io/github/commit-activity/m/Franek-Antoniak/recipes-engine)](https://github.com/Franek-Antoniak/recipes-engine) [![Codacy Badge](https://app.codacy.com/project/badge/Grade/1569de5635744167894c7f731141850a)](https://www.codacy.com/gh/Franek-Antoniak/recipes-engine/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Franek-Antoniak/recipes-engine&amp;utm_campaign=Badge_Grade) [![LastCommit](https://img.shields.io/github/last-commit/Franek-Antoniak/recipes-engine)](https://github.com/Franek-Antoniak/recipes-engine) [![Deploy](https://img.shields.io/github/deployments/Franek-Antoniak/recipes-engine/recipes-engine)](https://recipes-engine.herokuapp.com/)
> Secure place for your recipes!

RecipesEngine is an API providing the ability to save your own recipes in a secure location and access to intelligently search for them.
<br>
Feel free to use it through my [heroku instance](https://recipes-engine.herokuapp.com/) or build the project on your own computer!

* ***Register** as a new user*
* ***Add** your own recipes*
* ***Change** or **delete** individual recipes*
* *Use the search engine to **search** your recipes with restrictions*

## Table of content

- [Local Installation](local-installation)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Technological description](#technological-description)
    - [Front-end](#front-end)
    - [Back-end](#back-end)
    - [Database](#database)
    - [Deployment](#deployment)
    - [Container](#container)
- [Screenshot](#screenshot)

## Local Installation

### Prerequisites
* [Docker](https://docs.docker.com/get-docker/)
* [Git](https://git-scm.com/downloads)

### Installation
 ``` bash
 git clone https://github.com/Franek-Antoniak/recipes-engine.git
 cd recipes-engine
 docer-compose up
```
> *[Link to local version of application](http://localhost:8080)*

## Technological description

### Front-end
> - As the application only contains an API, I have included and implemented Swagger 3.0 to make it easy to see its capabilities.

### Back-end 

#### *In a nutshell, the back-end is divided into 5 modules:*
> ##### Web
> - The web module contains the controllers which handle the requests from user
> - There are three controllers:
>> - RecipeController
>> - UserController
>> - GlobalExceptionController
> - The first two controllers deal with the recipes and the user in turn. They also include exception handling. 
> -  The last controller deals with exception handling, which is repeated in each controller.
> ##### Facade
> - It is responsible for the facade between the service logic and the controller logic. 
> - It is, in a sense, an adapter between controller and service. Uses individual UseCases to achieve individual actions.
> - Facade is also connection between other services not directly related to recipes - for example: UserService. 
> ##### UseCases
> - Each of the ucecases is responsible for solving a problem, often a recurring one. 
> - It is a class with only one method - execute. This increases the readability of the code, and reduces the likelihood of errors.
> ##### Service
> - The services are responsible for communication with the repository and operations on the data. 
> - They do not contain much domain-related logic, thus reducing the number of methods or the possibility of errors.
> ##### Repository
> - Repositories communicate with the database. They also create personalised methods through the implementation of JpaSpecificationExecutor.

#### *Detailed description*
> - To implement the back-end, I have used Java 11 along with the Spring framework with the following modules: 
>> - Spring Boot
>> - Spring Data
>> - Spring Security
>> - Spring MVC
>> - Spring Actuator
> - I have used Gradle for the build automation tool. 
> - Other libraries in the project:
>> - Mapstruct
>> - Lombok
>> - Hibernate Validator
>> - Hibernate 
>> - Swagger 3.0
>> - JPA Model Generator
>> - PostgreSQL
> - Patterns such as Builder, Facade, UseCase, DTO, Adapter, Decorator, Observer, State, Dependency Injection, and Proxy were used in the design all across of the application.
> - All connections are authorized, and the user should not be able to find vulnerable places in the application. 

### Database
> - The database used in this application is PostgreSQL.
> - The schema and the data are automatically generated when the application starts.

### Deployment 
> - The application has been deployed on Heroku platform along with PostgreSQL addon.

### Container
> - To make it easier to work with the application, I used Docker together with Docker Compose. 
> - This increases security and makes it easier to configure the application. 
> - By using a container, we do not need to download PostgreSQL additionally.

# Screenshot

<p align="center">
  <a href="https://github.com/Franek-Antoniak/recipes-engine">
  <img src="https://i.imgur.com/PZzUWSY.png" alt="Swagger Screenshot" width="1060"/></a>
</p>

#
<p align="center">
  <a href="https://github.com/Franek-Antoniak/image-vote">
  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" alt="Java"/>
  </a>
  <a href="https://github.com/Franek-Antoniak/image-vote">
  <img src="https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white" alt="Heroku"/>
  </a>
  <a href="https://github.com/Franek-Antoniak/image-vote">
  <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring"/>
  </a>
  <a href="https://github.com/Franek-Antoniak/image-vote">
  <img src="https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white" alt="Postgres"/>
  </a>
  <a href="https://github.com/Franek-Antoniak/image-vote">
  <img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white" alt="Docker"/>
  </a>
  <a href="https://github.com/Franek-Antoniak/image-vote">
  <img src="https://img.shields.io/badge/Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white" alt="Swagger"/>
  </a>
  <a href="https://github.com/Franek-Antoniak/image-vote">
  <img src="https://img.shields.io/badge/Hibernate-%2359666C.svg?style=for-the-badge&logo=hibernate&logoColor=white" alt="Hibernate"/>
  </a>
  <a href="https://github.com/Franek-Antoniak/image-vote">
  <img src="https://img.shields.io/badge/Gradle-%2302303A.svg?style=for-the-badge&logo=hibernate&logoColor=white" alt="Gradle"/>
  </a>
</p>

