pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "loacq"
rootProject.buildFileName = "build.gradle.kts"

include(":app")
include(":core:design_system")
include(":core:domain")
include(":core:data")
