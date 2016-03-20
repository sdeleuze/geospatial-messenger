This is a sample application that demonstrates how to build a Kotlin + Spring Boot applications with a PostgreSQL database.
The code is very concise, and the generated application is a 18 MBytes self-contained executable jar with low memory consumption.

**This branch is based on [`spring-data-jdbc-repository`](https://github.com/jirutka/spring-data-jdbc-repository/)
(this is an improved fork by [Jakub Jirutka](Jakub Jirutka) of the [original project](https://github.com/nurkiewicz/spring-data-jdbc-repository))
instead of [Exposed](https://github.com/JetBrains/Exposed) on the master branch. There is no Spring Data JPA version yet but
feel free to fork this repo and contribute it with a pull request!**

It is used as a playground to demonstrate various features:
 - Simple [User](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/domain/User.kt)
   and [Message](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/domain/Message.kt)
   domain model classes thanks to [Kotlin data classes](https://kotlinlang.org/docs/reference/data-classes.html).
 - The [Application](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/Application.kt)
   class shows how to configure a Kotlin Spring Boot application. 
 - Spring Data with SQL (no JPA) based on [`spring-data-jdbc-repository`](https://github.com/jirutka/spring-data-jdbc-repository/).
 - [Controllers](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/web/MessageController.kt)
   demonstrates how to use Spring Framework 4.3 upcoming `@GetMapping` and `@PostMapping` annotation shortcuts, as well as Server-Sent Events
   to push data to the client.
 - The REST API is fully tested and documented thanks to the awesome [Spring REST docs](http://projects.spring.io/spring-restdocs/)
   , see [MessageControllerTests](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/test/kotlin/io/spring/messenger/MessageControllerTests.kt)
   and [index.adoc](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/asciidoc/index.adoc).
 - The client side is a pure HTML + Javascript application developed with [OpenLayers](http://openlayers.org) mapping library, see
   [index.html](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/resources/static/index.html)
   and [map.js](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/resources/static/map.js).
     
## Run the application

 - Install a PostgreSQL database with PostGis extension, on Mac you can use [Postgresapp](http://postgresapp.com/).
 - Clone this repository.
 - Customize database configuration on [application.yml](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/resources/application.yml).
 - Run it within your IDE or with `./gradlew bootRun`.
 - Open `http://localhost:8080/` in your browser.
![Screenshot](/screenshot.png?raw=true)
 - Documentation should be available at `http://localhost:8080/docs/index.html` when run from the JAR.

 
## Improvements I have in mind
 - [Spring HATEOAS issue #401](https://github.com/spring-projects/spring-hateoas/issues/401): add HATEOAS support, but without having to extend
   `ResourceSupport` or wrapping it into a `Resource<Foo>` container .
 - [Kotlin issue KT-11235](https://youtrack.jetbrains.com/issue/KT-11235): avoid mandatory usage of `arrayOf` in annotation array attribute
   (for example in `@SpringApplicationConfiguration(classes = arrayOf(Application::class))`.
