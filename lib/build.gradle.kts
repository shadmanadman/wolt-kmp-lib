plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
}

kotlin {
    // Android library
    androidLibrary {
        namespace = "wolt.kmp.lib"
        compileSdk = 36
        minSdk = 36
    }

    // iOS Framework
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "woltKit"
            isStatic = true
        }
    }

    sourceSets{
        commonMain.dependencies {  }
        androidMain.dependencies { }
        iosMain.dependencies {  }
    }
}