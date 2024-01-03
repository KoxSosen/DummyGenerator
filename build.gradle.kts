plugins {
    id("java")
    id("io.ktor.plugin") version "2.3.7"
}

group = "com.github.koxsosen"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        name= "arim-mvn-lgpl3"
        url = uri("https://mvn-repo.arim.space/lesser-gpl3/")
    }
    maven {
        name= "arim-mvn-gpl3"
        url = uri("https://mvn-repo.arim.space/gpl3/")
    }
    maven {
        name= "arim-mvn-agpl3"
        url = uri("https://mvn-repo.arim.space/affero-gpl3/")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    implementation("space.arim.libertybans:bans-env-standalone:1.1.0-SNAPSHOT")
    implementation("org.yaml:snakeyaml:2.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.github.javafaker:javafaker:1.0.2") {
        exclude("org.yaml")
    }
    implementation("org.slf4j:slf4j-simple:2.0.10")
}

application {
    mainClass.set("com.github.koxsosen.Main")
}

ktor {
    fatJar {
        archiveFileName.set("DummyGenerator-" + project.version + "-all.jar")
    }
}

tasks.test {
    useJUnitPlatform()
}