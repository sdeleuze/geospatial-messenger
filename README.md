This is a sample application that demonstrates how to build a Kotlin + Spring Boot applications with a PostgreSQL database.
The code is very concise, and the generated application is a 18 MBytes self-contained executable jar with low memory consumption.

A detailed blog post describing this application is available [here](https://spring.io/blog/2016/03/20/a-geospatial-messenger-with-kotlin-spring-boot-and-postgresql).

It is used as a playground to demonstrate various features:
 - Gradle [build.gradle.kts](https://github.com/sdeleuze/geospatial-messenger/blob/master/build.gradle.kts) file written in Kotlin instead of Groovy, see [gradle-script-kotlin](https://github.com/gradle/gradle-script-kotlin/releases) for more details.
 - Simple [User](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/domain/User.kt)
   and [Message](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/domain/Message.kt)
   domain model classes thanks to [Kotlin data classes](https://kotlinlang.org/docs/reference/data-classes.html).
 - The [Application](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/Application.kt)
   class shows how to configure a Kotlin Spring Boot application. 
 - Typesafe SQL DSL with [Exposed](https://github.com/JetBrains/Exposed) that allows to define your
   [SQL tables](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/Database.kt#L8-L20)
   and describe your [SQL requests](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/repository/MessageRepository.kt)
   with a fluent API without requiring code generation.
 - [Controllers](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/web/MessageController.kt)
   demonstrates how to use Spring Framework 4.3 upcoming `@GetMapping` and `@PostMapping` annotation shortcuts, as well as Server-Sent Events
   to push data to the client.
 - [Kotlin extensions](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/Database.kt#L23-L42)
    allows to add Geospatial support to [Exposed](https://github.com/JetBrains/Exposed) and
    [use it](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/kotlin/io/spring/messenger/repository/UserRepository.kt#L35-L37)
    as if this was supported out of the box. 
 - The REST API is fully tested and documented thanks to the awesome [Spring REST docs](http://projects.spring.io/spring-restdocs/)
   , see [MessageControllerTests](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/test/kotlin/io/spring/messenger/MessageControllerTests.kt)
   and [index.adoc](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/asciidoc/index.adoc).
 - The client side is originally a pure HTML + Javascript application developed with [OpenLayers](http://openlayers.org) mapping library, see [index.html](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/resources/static/index.html) and [map.js](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/resources/static/map.js). But an experimental (work in progress) Kotlin2js version has ben contributed by @bashor, you can find it [here](https://github.com/sdeleuze/geospatial-messenger/tree/kotlin-js/gm-client/src/main/kotlin).

A Spring Data version based on [spring-data-jdbc-repository](https://github.com/jirutka/spring-data-jdbc-repository/) is also available in [this branch](https://github.com/sdeleuze/geospatial-messenger/tree/spring-data-jdbc-repository). There is no Spring Data JPA version yet but feel free to fork this repo and contribute it with a pull request!
     
## Run the application

 - Install a PostgreSQL database with PostGis extension, on Mac you can use [Postgresapp](http://postgresapp.com/).
 - Clone this repository.
 - Customize database configuration on [application.yml](https://github.com/sdeleuze/geospatial-messenger/blob/master/src/main/resources/application.yml).
 - Run it within your IDE or with `./gradlew bootRun`.
 - Open `http://localhost:8080/` in your browser.
![Screenshot](/screenshot.png?raw=true)
 - Documentation should be available at `http://localhost:8080/docs/index.html` when run from the JAR.

 
## Improvements I have in mind
 - [Exposed issue #24](https://github.com/JetBrains/Exposed/issues/24): see if Exposed could support natively data classes + repository patten.
 - [Spring HATEOAS issue #401](https://github.com/spring-projects/spring-hateoas/issues/401): add HATEOAS support, but without having to extend
   `ResourceSupport` or wrapping it into a `Resource<Foo>` container .
