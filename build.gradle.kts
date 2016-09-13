buildscript {

  extra["kotlinVersion"] = "1.0.3"
  extra["exposedVersion"] = "0.5.0"

  repositories {
    mavenCentral()
    gradleScriptKotlin()
  }
  dependencies {
    classpath(kotlinModule("gradle-plugin"))
    classpath("org.springframework.boot:spring-boot-gradle-plugin:1.4.0.RELEASE")
  }
}

apply {
  plugin("kotlin")
  plugin("spring-boot")
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

  compile(kotlinModule("stdlib", extra["kotlinVersion"]))
  compile(kotlinModule("reflect", extra["kotlinVersion"]))
  compile("io.projectreactor:reactor-core:3.0.0.RC1")
  compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.7.5")

  compile("org.jetbrains.exposed:exposed:${extra["exposedVersion"]}")
  compile("org.jetbrains.exposed:spring-transaction:${extra["exposedVersion"]}")
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
