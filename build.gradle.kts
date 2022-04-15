plugins {
    kotlin("jvm") version "1.5.30"
    id("org.springframework.boot") version "2.6.1"
}

group = "ru.sindm"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("org.springframework.boot:spring-boot-starter-web:2.6.1")

    implementation("org.springframework.boot:spring-boot-starter-jdbc:2.6.1")

    implementation("org.springframework.boot:spring-boot-starter-actuator:2.6.1")

    implementation("org.postgresql:postgresql:42.3.1")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.1")

    testImplementation("org.mockito:mockito-inline:4.1.0")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

}

tasks.withType<Test> {
    useJUnitPlatform()
}