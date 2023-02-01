# android-dawn

안드로이드를 개발하면서 비슷한 프로젝트 생성에 귀찮아 템플릿 프로젝트를 제작하였습니다.

대부분의 소스는 https://github.com/android/nowinandroid 를 참고하였습니다.

기본적인 레이어와 모듈 구성을 각 개발자마다 다르기에 추가하지 않고, app 모듈 1개만 존재합니다.

라이브러리 버전은 버전 카탈로그를 통해 관리 합니다.

> 자바 & 코틀린 라이브러리 모듈의 build.gradle 은 아래와 같이 설정해주세요.

``` kotlin
plugins {
    `java-library`
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
```

> 안드로이드 라이브러리 모듈의 build.gradle 은 아래와 같이 설정해주세요.

``` kotlin
plugins {
    id("dawn.android.library")
}

android {
    namespace = "io.github.dawn"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies { ... }
```