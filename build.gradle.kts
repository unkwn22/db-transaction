import java.util.*

plugins {
    java
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // QueryDsl
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    annotationProcessor("com.querydsl:querydsl-apt:5.0.0:jakarta")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
}

fun retrieveProperties(): MutableMap<String, String>
{
    val absolutePath = project.projectDir.absolutePath
    val envFile = File("${absolutePath}/src/main/resources/env.properties").inputStream()
    val properties = Properties()
    properties.load(envFile)

    val configMap = mutableMapOf<String, String>()
    for(key in properties.stringPropertyNames()){
        configMap[key] = properties.getProperty(key)
    }

    return configMap
}

tasks.withType<Test> {
    useJUnitPlatform()
    val configMap = retrieveProperties()
    environment(configMap)
}
