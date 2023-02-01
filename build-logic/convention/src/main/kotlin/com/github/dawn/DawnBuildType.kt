package com.github.dawn

enum class DawnBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE("release"),
}