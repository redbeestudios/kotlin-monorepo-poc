group = "myapp.infrastructure"
version = "unspecified"

dependencies {
    implementation(project(":users:core"))
    implementation(project(":users:entities"))
    implementation(project(":users:rest"))
}