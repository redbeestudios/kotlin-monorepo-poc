plugins {
    kotlin("jvm") version "1.4.10"
}

version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.ktorm:ktorm-core:${findProperty("ktorm_version")}")
    implementation("com.mchange:c3p0:0.9.5.5")
}
