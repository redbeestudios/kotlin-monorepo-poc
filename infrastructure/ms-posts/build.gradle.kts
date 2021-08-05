group = "myapp.infrastructure"
version = "unspecified"

dependencies {
    implementation(project(":posts:core"))
    implementation(project(":posts:entities"))
    implementation(project(":posts:rest"))

    implementation(project(":users:abstractions"))
    implementation(project(":users:restclient"))
}