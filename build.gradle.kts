plugins {
    kotlin("jvm") version "1.9.0"
    `maven-publish`
}

group = "com.github.supergluelib"
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

// This makes it so Jitpack excludes the transitive bukkit dependency from Vault -- I don't know why.
tasks.withType<GenerateModuleMetadata> {
    enabled = false
}

publishing.publications.create<MavenPublication>("maven") {
    groupId = group as String
    artifactId = "VaultWrapper"
    version = this.version

    from(components["java"])
}