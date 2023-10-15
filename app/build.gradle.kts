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

    implementation(project(Modules.presentation))
    implementation(project(":core_navigation"))
    implementation(project(":feature_one:impl"))
    implementation(project(":feature_one:api"))


    implementation(Dependencies.JetpackCompose.runtime)
    implementation(Dependencies.JetpackCompose.navigation)
    implementation(Dependencies.JetpackCompose.activityCompose)
    implementation(Dependencies.DI.koin)


//    implementation(Dependencies.Android.androidCore)

//    implementation 'androidx.core:core-ktx:+'
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
//    androidTestImplementation platform('androidx.compose:compose-bom:2022.10.00')
//    androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
//    debugImplementation 'androidx.compose.ui:ui-tooling'
//    debugImplementation 'androidx.compose.ui:ui-test-manifest'
}
