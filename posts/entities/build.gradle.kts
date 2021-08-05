version = "unspecified"

dependencies {
    implementation(project(":shared:database"))
    implementation(project(":posts:abstractions"))
    implementation(project(":posts:core"))
    implementation("org.ktorm:ktorm-core:${findProperty("ktorm_version")}")
}
