plugins {
    kotlin("jvm") version "2.0.21"
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
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}