import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.google.protobuf.gradle.*

buildscript {
	dependencies {
		classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.14")
	}
}

plugins {
	id("org.springframework.boot") version "2.5.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.google.protobuf") version "0.8.11"
	id("idea")
	id("java")
	kotlin("jvm") version "1.5.21"
	kotlin("plugin.spring") version "1.5.21"
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
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("com.google.protobuf:protobuf-java:3.6.1")
	implementation("io.github.lognet:grpc-spring-boot-starter:4.5.6")
	implementation("io.grpc:grpc-stub:1.15.1")
	implementation("io.grpc:grpc-protobuf:1.15.1")
	implementation("io.reactivex.rxjava2:rxjava:2.2.20")
	implementation("com.salesforce.servicelibs:rxgrpc-stub:1.2.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
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
			artifact = "io.grpc:protoc-gen-grpc-java:1.15.1"
		}
		id("rxgrpc") {
			artifact = "com.salesforce.servicelibs:rxgrpc:1.2.0"
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
