version = "unspecified"

dependencies {
    implementation("org.ktorm:ktorm-core:${findProperty("ktorm_version")}")
    implementation("com.mchange:c3p0:0.9.5.5")
}
