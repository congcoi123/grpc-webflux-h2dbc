import com.google.protobuf.gradle.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springBootVersion = "2.4.4"
val grpcStarterVersion = "4.4.5"
val googleCommonProtosVersion = "2.5.0"
val grpcVersion = "1.40.1"
val rxgrpcVersion = "1.2.0"
val rxJavaVersion = "2.2.20"
val h2R2dbcVersion = "1.0.0.BUILD-SNAPSHOT"
val r2dbcSpiVersion = "1.0.0.M7"

buildscript {
    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.14")
    }
}

plugins {
    id("org.springframework.boot") version "2.4.4"
    id("com.google.protobuf") version "0.8.8"
    id("io.gitlab.arturbosch.detekt") version "1.18.1"
    id("idea")
    id("java")
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.spring") version "1.4.30"
}

group = "com.congcoi123.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.spring.io/snapshot")
    maven("https://repo.spring.io/milestone")
}

dependencies {
    // spring boot
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.4")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // swagger
    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.4.3")

    // detekt
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.3")

    // grpc base configuration
    implementation("io.github.lognet:grpc-spring-boot-starter:$grpcStarterVersion")

    // grpc
    implementation("com.google.api.grpc:proto-google-common-protos:$googleCommonProtosVersion")
    implementation("io.grpc:grpc-netty:$grpcVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("io.projectreactor.addons:reactor-adapter:3.4.5")

    // reactive grpc
    implementation("com.salesforce.servicelibs:rxgrpc-stub:$rxgrpcVersion")

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.30")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.30")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.5.2")

    // reactive
    implementation("io.reactivex.rxjava2:rxjava:$rxJavaVersion")

    // database
    implementation("org.springframework.data:spring-data-r2dbc:1.3.5")
    implementation("io.r2dbc:r2dbc-spi:0.9.0.M2")
    implementation("io.r2dbc:r2dbc-h2:0.8.4.RELEASE")
    implementation("com.h2database:h2:1.4.200")

    // dev tools
    implementation("org.springframework.boot:spring-boot-devtools:2.5.4")

    // logging
    implementation("org.springframework.boot:spring-boot-starter-log4j2")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configurations {
    compile {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
    all {
        resolutionStrategy.eachDependency {
            if (requested.group == "org.springframework.boot") {
                useVersion(springBootVersion)
            }
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

protobuf {
    generatedFilesBaseDir = "${projectDir}/src/generated/"

    protoc {
        artifact = "com.google.protobuf:protoc:3.6.1"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
        id("rxgrpc") {
            artifact = "com.salesforce.servicelibs:rxgrpc:$rxgrpcVersion"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.doFirst {
                delete("${projectDir}/src/generated/")
            }
            it.plugins {
                id("grpc") {
                    outputSubDir = "java"
                }
                id("rxgrpc") {
                    outputSubDir = "rxgrpc"
                }
            }
        }
    }
}

tasks["clean"].doFirst {
    delete("${projectDir}/src/generated/")
}

detekt {
    reports {
        xml.enabled = false
        html.enabled = false
    }
    config = this.config.from("detekt-config.yml")
    parallel = true
    buildUponDefaultConfig = true
}
