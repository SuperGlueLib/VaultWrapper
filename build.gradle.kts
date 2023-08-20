plugins {
    kotlin("jvm") version "1.9.0"
    `maven-publish`
}

group = "me.superpenguin.superglue"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.19.4-R0.1-SNAPSHOT")
    implementation("com.github.MilkBowl:VaultAPI:1.7") {
        exclude("org.bukkit")
    }
}

publishing.publications.create<MavenPublication>("maven") {
    groupId = "me.superpenguin.superglue"
    artifactId = "superfoundations"
    version = "1.0.0"

    from(components["java"])
}