plugins {
    id("loacq.android.library")
    id("loacq.android.hilt")
}

android {
    namespace = "io.github.loacq"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {  }