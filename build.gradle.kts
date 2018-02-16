import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.2.21"
	id("org.jetbrains.kotlin.jvm") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
	id("io.spring.dependency-management") version "1.0.4.RELEASE"
}

buildscript {

	val kotlinVersion = "1.2.21"

	repositories {
		mavenCentral()
		maven("https://repo.spring.io/milestone")
	}
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
		classpath("org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}")
		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.RC1")
	}
}

apply {
	plugin("org.springframework.boot")
}

tasks {
	withType<KotlinCompile> {
		kotlinOptions {
			jvmTarget = "1.8"
			freeCompilerArgs = listOf("-Xjsr305=strict")
		}
	}
}

repositories {
	mavenCentral()
	maven("https://repo.spring.io/milestone")
	maven("https://dl.bintray.com/kotlin/exposed")
	maven("https://dl.bintray.com/sdeleuze/maven/")
}

dependencies {
	compile("org.springframework.boot:spring-boot-starter-web") {
		exclude(module = "spring-boot-starter-validation")
	}
	compile("org.springframework.boot:spring-boot-starter-jdbc")
	compile("org.springframework.boot:spring-boot-devtools")

	compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	compile("org.jetbrains.kotlin:kotlin-reflect")
	compile("com.fasterxml.jackson.module:jackson-module-kotlin")

	compile("org.jetbrains.exposed:exposed:0.8")
	compile("org.jetbrains.exposed:spring-transaction:0.8")
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

