rootProject.name = "homework8"

pluginManagement {
    plugins {
        val springBootVersion: String by settings
        val springDependencyVersion: String by settings
        val flywayVersion: String by settings

        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyVersion
        id("org.flywaydb.flyway") version flywayVersion
    }
}