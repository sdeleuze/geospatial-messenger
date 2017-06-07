buildscript {

  extra["kotlinVersion"] = "1.1.2-4"

  repositories {
    mavenCentral()
  }
  dependencies {
    classpath(kotlinModule("gradle-plugin", extra["kotlinVersion"] as String))
    classpath(kotlinModule("allopen", extra["kotlinVersion"] as String))
    classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.3.RELEASE")
  }
}

apply {
  plugin("kotlin")
  plugin("kotlin-spring")
  plugin("org.springframework.boot")
}

repositories {
  mavenCentral()
  maven { setUrl("https://dl.bintray.com/kotlin/exposed") }
  maven { setUrl("https://dl.bintray.com/sdeleuze/maven/") }
}

dependencies {
  compile("org.springframework.boot:spring-boot-starter-web") {
    exclude(module = "spring-boot-starter-validation")
  }
  compile("org.springframework.boot:spring-boot-starter-jdbc")
  compile("org.springframework.boot:spring-boot-devtools")

  compile(kotlinModule("stdlib", extra["kotlinVersion"] as String))
  compile(kotlinModule("reflect", extra["kotlinVersion"] as String))
  compile("com.fasterxml.jackson.module:jackson-module-kotlin")

  compile(exposedModule("exposed"))
  compile(exposedModule("spring-transaction"))
  compile("org.postgresql:postgresql:9.4.1208")
  compile("net.postgis:postgis-jdbc:2.2.0") {
    exclude(module = "postgresql")
  }
  compile("com.github.mayconbordin:postgis-geojson:1.1")  {
    exclude(module = "postgresql")
  }

  testCompile("org.springframework.boot:spring-boot-starter-test")
  testCompile("org.springframework.restdocs:spring-restdocs-mockmvc:1.1.1.RELEASE")
}

fun exposedModule(module: String) = "org.jetbrains.exposed:$module:0.8"
