import org.gradle.api.tasks.bundling.Jar
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("plugin.jpa") version "1.4.32" apply false
    id("org.springframework.boot") version "2.4.4" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    kotlin("jvm") version "1.4.32" apply false
    kotlin("plugin.spring") version "1.4.32" apply false
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    val implementation by configurations
    val runtimeOnly by configurations
    val testImplementation by configurations
    val annotationProcessor by configurations

    dependencies {
        implementation(kotlin("stdlib"))
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.springframework.boot:spring-boot-configuration-processor")
        runtimeOnly("org.springframework.boot:spring-boot-devtools")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    }

    if (!this.name.startsWith(":infrastructure:")) {
        val jar: Jar by tasks
        val bootJar: BootJar by tasks

        bootJar.enabled = false
        jar.enabled = true
    }
}