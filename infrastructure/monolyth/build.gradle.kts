import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "myapp.infrastructure"
version = "unspecified"

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}