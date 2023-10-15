plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.turtleteam.core_navigation"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependencies.JetpackCompose.runtime)
    implementation(Dependencies.JetpackCompose.activityCompose)
    implementation(Dependencies.JetpackCompose.ui)
    implementation(Dependencies.JetpackCompose.foundation)
    api(Dependencies.JetpackCompose.navigation)
}