import com.android.build.api.dsl.ApplicationExtension
import com.github.dawn.buildVersionCode
import com.github.dawn.buildVersionName
import com.github.dawn.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 33
                defaultConfig.versionCode = buildVersionCode()
                defaultConfig.versionName = buildVersionName()
            }
        }
    }
}