plugins {
    kotlin("jvm") version "1.4.10"
}

version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":users:core"))
    implementation("org.springframework:spring-context:${findProperty("spring_framework_version")}")
    implementation("org.springframework:spring-web:${findProperty("spring_framework_version")}")
}
