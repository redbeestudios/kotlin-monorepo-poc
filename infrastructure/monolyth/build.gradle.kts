import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "myapp.infrastructure"
version = "unspecified"

dependencies {
    implementation(project(":users:core"))
    implementation(project(":users:entities"))
    implementation(project(":users:rest"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}