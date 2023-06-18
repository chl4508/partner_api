import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.bundling.BootWar

plugins {
    id("java")
}

group = "cys.partner"
version = "0.0.1-SNAPSHOT"

val jar: Jar by tasks
val bootWar: BootWar by tasks
val bootJar: BootJar by tasks

bootWar.enabled = true
bootJar.enabled = true
jar.enabled = true

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}