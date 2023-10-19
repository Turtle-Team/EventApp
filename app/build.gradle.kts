plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.turtleteam.eventapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.turtleteam.eventapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(Modules.core_navigation))
    implementation(project(Modules.core_view))
    implementation(project(Modules.core_data))

    implementation(project(":feature:account:api"))
    implementation(project(":feature:account:impl"))

    implementation(project(":feature:home:api"))
    implementation(project(":feature:home:impl"))

    implementation(project(":feature:event:api"))
    implementation(project(":feature:event:impl"))

    implementation(project(":feature:profile:api"))
    implementation(project(":feature:profile:impl"))


    implementation("androidx.compose.material:material:1.5.4")

    implementation(Dependencies.Data.ktorClient)
    implementation(Dependencies.JetpackCompose.runtime)
    implementation(Dependencies.JetpackCompose.navigation)
    implementation(Dependencies.JetpackCompose.activityCompose)
    implementation(Dependencies.JetpackCompose.material)
    implementation(Dependencies.DI.koin)
    implementation(Dependencies.DI.koinAndroid)
    implementation(Dependencies.Data.ktorJson)
    implementation(Dependencies.Data.ktorCore)
    implementation(Dependencies.Data.ktorLogging)
    implementation(Dependencies.Data.ktorContentNegotiation)
    implementation(Dependencies.Kotlin.kotlinxSerialization)
}
