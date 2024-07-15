import org.jetbrains.kotlin.tooling.core.withClosure

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.detekt) apply true

}


allprojects.onEach { proj ->
    proj.afterEvaluate {
        with(proj.plugins) {
            if (hasPlugin(libs.plugins.jetbrains.kotlin.android.get().pluginId)) {
                apply(libs.plugins.detekt.get().pluginId)
            }
        }


    }

}
