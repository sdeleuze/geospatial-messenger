buildscript {

  extra["kotlinVersion"] = "1.1-M02"

  repositories {
    mavenCentral()
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1")}
  }
  dependencies {
    classpath(kotlinModule("gradle-plugin", extra["kotlinVersion"] as String))
    classpath("org.springframework.boot:spring-boot-gradle-plugin:1.4.1.RELEASE")
  }
}

apply {
  plugin("kotlin")
  plugin("spring-boot")
}

repositories {
  mavenCentral()
  maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1")}
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
  compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.8.4")

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

fun exposedModule(module: String) = "org.jetbrains.exposed:$module:0.5.0"
