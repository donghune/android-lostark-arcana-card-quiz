package com.github.dawn

enum class BuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE("release"),
}