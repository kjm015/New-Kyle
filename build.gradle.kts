val jdaVersion = "4.2.0_214"
val jdaUtilitiesVersion = "3.0.4"
val jLyricsVersion = "0.4"
val springBootVersion = "2.6.6"

plugins {
    val springBootVersion = "2.6.6"
    val kotlinVersion = "1.6.21"
    id("org.springframework.boot") version springBootVersion
    kotlin("jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    idea
    java
    eclipse
}

apply(plugin = "io.spring.dependency-management")

group = "io.github.kjm015"
version = "0.0.2-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    // Spring Boot dependencies
    implementation("org.springframework.boot:spring-boot-starter-hateoas:${springBootVersion}")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:${springBootVersion}")
    runtimeOnly("org.springframework.boot:spring-boot-devtools:${springBootVersion}")

    // Kotlin dependencies
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Discord dependencies
    implementation("com.jagrosh:jda-utilities:${jdaUtilitiesVersion}")
    implementation("net.dv8tion:JDA:${jdaVersion}")
    implementation("com.jagrosh:JLyrics:$jLyricsVersion")

    // Misc. dependencies
    runtimeOnly("com.h2database:h2:2.1.212")
    implementation("commons-io:commons-io:20030203.000550")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")
    implementation("junit:junit:4.13.2")

    // Spring Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test:${springBootVersion}")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:${springBootVersion}")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
