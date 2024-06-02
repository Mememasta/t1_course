plugins {
    java
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.flywaydb.flyway")
}

group = "ru.vtb.t1.course.transfer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    runtimeOnly("org.postgresql:postgresql")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

flyway {
    url = System.getenv("SPRING_JDBC_URL")
    user = System.getenv("SPRING_JDBC_USERNAME")
    password = System.getenv("SPRING_JDBC_PASSWORD")
    schemas = arrayOf(System.getenv("SPRING_JDBC_SCHEMA"))
    baselineOnMigrate = true
    locations = arrayOf("filesystem:resources/db/migration")
}

tasks.withType<Test> {
    useJUnitPlatform()
}