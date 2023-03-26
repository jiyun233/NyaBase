plugins {
    kotlin("jvm") version "1.8.0"
    java
}

group = "kawaii.jiyun233.nya"
version = "0.0.1"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://repo.dmulloy2.net/repository/public/")
}

val include: Configuration by configurations.creating { }

dependencies {
    @Suppress("VulnerableLibrariesLocal")
    compileOnly("org.bukkit:bukkit:1.12.2-R0.1-SNAPSHOT")
    compileOnly("com.comphenix.protocol:ProtocolLib:4.7.0")

    include(kotlin("stdlib"))
    include("org.reflections:reflections:0.10.2")

    include("com.google.code.gson:gson:2.10.1")

    implementation(include)
}

tasks {
    jar {
        from(include.map { if (it.isDirectory) it else zipTree(it) })
        exclude("META-INF/**")
    }
}

val targetJavaVersion = 8
java {
    val javaVersion = JavaVersion.toVersion(targetJavaVersion)
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

