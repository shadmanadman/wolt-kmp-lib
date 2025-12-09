plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
}

kotlin {
    // Android library
    androidTarget {
        publishLibraryVariants("release")
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

android {
    namespace = "wolt.kmp.lib"
    compileSdk = 36
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}