version = "unspecified"

dependencies {
    implementation(project(":users:core"))
    implementation("org.springframework:spring-web:${findProperty("spring_framework_version")}")
}
