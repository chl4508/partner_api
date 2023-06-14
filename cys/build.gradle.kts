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
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	//testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
	//testImplementation("org.assertj:assertj-core:3.23.1")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")

	//mongodb
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.data:spring-data-mongodb:4.1.0")
	implementation("org.mongodb:mongodb-driver-sync:4.9.1")
	implementation("com.querydsl:querydsl-mongodb:4.4.0")

	// mysql
	//implementation("mysql:mysql-connector-java:5.1.13")
	implementation("com.mysql:mysql-connector-j:8.0.33")

	//jpa
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")


	//jwt
	implementation("io.jsonwebtoken:jjwt:0.9.1")

	//swagger
	implementation("org.springdoc:springdoc-openapi-starter-common:2.1.0")
	implementation("org.springdoc:springdoc-openapi-webmvc-core:1.7.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.1.0")
	implementation("org.springdoc:springdoc-openapi-data-rest:1.7.0")

	//redis
	implementation("org.springframework.boot:spring-boot-starter-data-redis:3.1.0")





}

tasks.named<Test>("test") {
	useJUnitPlatform()
}
