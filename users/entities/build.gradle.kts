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
    compile("org.ktorm:ktorm-core:${findProperty("ktorm_version")}")
}
