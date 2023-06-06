plugins {
	java
	war
	id("org.springframework.boot") version "3.1.1-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "cys.partner"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	//mongodb
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.data:spring-data-mongodb:4.1.0")
	implementation("org.mongodb:mongodb-driver-sync:4.9.1")

	//implementation("org.springframework.boot:spring-boot-starter-jdbc:3.1.0")
	//implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	implementation("com.querydsl:querydsl-mongodb:4.4.0")

	//jwt
	implementation("io.jsonwebtoken:jjwt:0.9.1")

	//swagger
	implementation("org.springdoc:springdoc-openapi-starter-common:2.1.0")
	implementation("org.springdoc:springdoc-openapi-webmvc-core:1.7.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.1.0")
	implementation("org.springdoc:springdoc-openapi-data-rest:1.7.0")



	//implementation("org.springdoc:springdoc-openapi-ui:1.7.0")




}

tasks.withType<Test> {
	useJUnitPlatform()
}
