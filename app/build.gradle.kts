plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jetbrainsKotlinKapt)
    alias(libs.plugins.googleDevtoolsKsp)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.googleService)
}

android {
    namespace = "np.com.siddharthaghimire.shuffly"
    compileSdk = 34

    defaultConfig {
        applicationId = "np.com.siddharthaghimire.shuffly"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.bundles.androidx)
    implementation(libs.bundles.hilt)
    implementation(platform(libs.firebase.bom))
    implementation(libs.bundles.firebase)
    implementation(libs.bundles.exoplayer)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.ui.testing)
    implementation(libs.bundles.unit.testing)
    implementation(libs.androidx.constraintlayout)

    ksp(libs.androidx.databinding.compiler)
    ksp(libs.androidx.databinding.common)
    ksp(libs.databinding.android.compiler)
    ksp(libs.hilt.compiler)
    ksp(libs.hilt.android.test.compiler)
    ksp(libs.glide.compiler)

    implementation(libs.material)
    implementation(libs.google.identity)
    implementation(libs.glide)

    implementation(libs.bundles.googleplay)

    implementation(libs.youtube.player)
    implementation(libs.lottie)
    implementation(libs.shimmer)
    implementation(libs.circleimage)

    testRuntimeOnly(libs.junit.jupiter.engine)
}