plugins {
    id("java")
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
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("space.arim.libertybans:bans-env-standalone:1.1.0-SNAPSHOT")
    implementation("org.yaml:snakeyaml:2.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.jeasy:easy-random-core:5.0.0")

}

tasks.test {
    useJUnitPlatform()
}