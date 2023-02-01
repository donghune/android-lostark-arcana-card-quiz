import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("dawn.android.library")
                apply("dawn.android.hilt")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", project(":common:design-system"))

                add("testImplementation", kotlin("test"))
                add("androidTestImplementation", kotlin("test"))

                add("implementation", libs.findLibrary("kotlinx.coroutines.android").get())
            }
        }
    }
}