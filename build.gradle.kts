import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.exclude
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.2.30"
	id("org.jetbrains.kotlin.jvm") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
}

buildscript {

	val kotlinVersion = "1.2.30"

	repositories {
		mavenCentral()
	}
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
		classpath("org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}")
		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.RELEASE")
	}
}

apply {
	plugin("org.springframework.boot")
	plugin("io.spring.dependency-management")
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
	maven ("https://jitpack.io")
	maven("https://dl.bintray.com/kotlin/exposed")
	maven("https://dl.bintray.com/sdeleuze/maven/")
}

dependencies {
	compile("org.springframework.boot:spring-boot-starter-web") {
		exclude(module = "spring-boot-starter-validation")
	}
	compile("org.springframework.boot:spring-boot-devtools")

	compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	compile("org.jetbrains.kotlin:kotlin-reflect")
	compile("com.fasterxml.jackson.module:jackson-module-kotlin")

	compile("com.github.mduesterhoeft:spring-boot-starter-exposed:0.1.6")
	compile("org.jetbrains.exposed:spring-transaction:0.10.1")
	compile("org.postgresql:postgresql:9.4.1208")
	compile("net.postgis:postgis-jdbc:2.2.0") {
		exclude(module = "postgresql")
	}
	compile("com.github.mayconbordin:postgis-geojson:1.1")  {
		exclude(module = "postgresql")
	}

	testCompile("org.springframework.boot:spring-boot-starter-test")
	testCompile("org.springframework.restdocs:spring-restdocs-mockmvc")
}

