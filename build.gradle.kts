plugins {
    id("com.gradleup.shadow") version "9.0.0-beta4"
    kotlin("jvm") version "2.0.21"
}


tasks {
    shadowJar {
        // Specify the main class to run
        manifest {
            attributes["Main-Class"] = "com.example.MainKt" // Replace with your main class path
        }
        archiveBaseName.set("my-shadow-jar") // Name of the JAR file
        archiveVersion.set("1.0.0") // Set the version if necessary
        mergeServiceFiles() // Optional: Merges service files from dependencies
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.apache.mina:mina-core:2.2.4")
//    implementation ("org.apache.socks:proxy-server:1.0.0")

    implementation("io.netty:netty-all:5.0.0.Alpha2")

//    implementation ("com.github.mosabua:socks5-proxy:1.0.1")


    implementation ("org.eclipse.jetty:jetty-server:12.0.16")
    implementation ("org.eclipse.jetty:jetty-servlet:11.0.24")

    // https://mvnrepository.com/artifact/com.github.jengelman.gradle.plugins/shadow
//    implementation("com.github.jengelman.gradle.plugins:shadow:6.1.0")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}