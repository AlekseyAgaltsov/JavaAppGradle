plugins {
    id("java")
    id("maven-publish")

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("http://localhost:8081/repository/maven-snapshots/") // URL вашего Nexus репозитория
        credentials {
            username = project.findProperty('user')
            password = project.findProperty('')
        }
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}