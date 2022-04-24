val jdaVersion = "4.2.0_214"
val jdaUtilitiesVersion = "3.0.4"
val jLyricsVersion = "0.4"

plugins {
    id("org.jetbrains.kotlin.plugin.jpa") version embeddedKotlinVersion
    id("org.springframework.boot") version "2.5.13"
    id("org.jetbrains.kotlin.jvm") version embeddedKotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version embeddedKotlinVersion
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
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("commons-io:commons-io:2.6")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.apache.httpcomponents:httpclient:4.5.8")

    // Discord dependencies
    implementation("com.jagrosh:jda-utilities:${jdaUtilitiesVersion}")
    implementation("net.dv8tion:JDA:${jdaVersion}")
    implementation("com.jagrosh:JLyrics:$jLyricsVersion")
    implementation("junit:junit:4.13.1")

    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
