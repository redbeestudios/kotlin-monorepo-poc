version = "unspecified"

dependencies {
    implementation(project(":shared:database"))
    implementation(project(":users:abstractions"))
    implementation(project(":users:core"))
    implementation("org.ktorm:ktorm-core:${findProperty("ktorm_version")}")
}
