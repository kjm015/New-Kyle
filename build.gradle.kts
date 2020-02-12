val springBootVersion = "2.2.2.RELEASE"
val jdaVersion = "4.1.1_108"
val jdaUtilitiesVersion = "3.0.2"
val jLyricsVersion = "0.4"

plugins {
    id("org.jetbrains.kotlin.plugin.jpa") version embeddedKotlinVersion
    id("org.springframework.boot") version "2.2.2.RELEASE"
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
    "implementation"("org.springframework.boot:spring-boot-starter-hateoas")
    "implementation"("org.springframework.boot:spring-boot-starter-data-jpa")
    "implementation"("commons-io:commons-io:2.6")

    "implementation"("org.jetbrains.kotlin:kotlin-reflect")
    "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    "implementation"("org.apache.httpcomponents:httpclient:4.5.8")

    // Discord dependencies
    "implementation"("com.jagrosh:jda-utilities:${jdaUtilitiesVersion}")
    "implementation"("net.dv8tion:JDA:${jdaVersion}")
    "implementation"("com.jagrosh:JLyrics:$jLyricsVersion")

    "runtimeOnly"("org.springframework.boot:spring-boot-devtools")
    "runtimeOnly"("com.h2database:h2")

    "testImplementation"("org.springframework.boot:spring-boot-starter-test")
    "annotationProcessor"("org.springframework.boot:spring-boot-configuration-processor")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_12
    targetCompatibility = JavaVersion.VERSION_12
}
