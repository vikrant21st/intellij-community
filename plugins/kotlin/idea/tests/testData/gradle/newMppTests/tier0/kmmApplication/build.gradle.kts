plugins {
    kotlin("multiplatform")
    id("com.android.application")
}

repositories {
    {{ kts_kotlin_plugin_repositories }}
}

kotlin {
    android()
    ios()

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
