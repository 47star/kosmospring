plugins {
    val kotlin = "1.7.20"
    val spring = "2.7.5"

    kotlin("jvm") version kotlin
    kotlin("kapt") version kotlin
    kotlin("plugin.serialization") version kotlin
    kotlin("plugin.spring") version kotlin
    kotlin("plugin.jpa") version kotlin
    kotlin("plugin.noarg") version kotlin
    kotlin("plugin.allopen") version kotlin
    id("org.springframework.boot") version spring
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("com.donghoonyoo.boilerplate:gradle-kotlin-boilerplate:1.0.1")
    }
}

group = "com.donghoonyoo.practice"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation(kotlinx("coroutines-core"))
    implementation(kotlinx("coroutines-reactor"))
    implementation(kotlinx("serialization-json"))
    implementation(kotlinx("datetime"))

    // Spring
    implementation(springBoot("starter"))
    implementation(springBoot("starter-data-jpa"))
    implementation(springBoot("starter-web"))
    implementation(springBoot("starter-webflux"))
    kapt(springBoot("configuration-processor"))

    // Azure Cosmos DB
    implementation("com.azure:azure-spring-data-cosmos:3.29.0")
}

springBoot {
    mainClass.set("com.donghoonyoo.practice.kosmospring.KosmospringApplication")
}

allOpen {
    annotation("com.azure.spring.data.cosmos.core.mapping.Container")
}

noArg {
    annotation("com.azure.spring.data.cosmos.core.mapping.Container")
}