// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("minSdk", 23)
        set("targetSdk", 34)
        set("compileSdk", 34)
        set("applicationId", "np.com.siddharthaghimire.shuffly")
        set("versionName", "letup")
        set("androidJUnitRunner", "androidx.test.runner.AndroidJUnitRunner")
        set("buildTypeDebug", "debug")
        set("buildTypeRelease", "release")
        set("jvmTargetVersion", "17")
        set("proguardOptimize", "proguard-android-optimize.txt")
        set("proguardRulesPro", "proguard-rules.pro")
        set("appName", "Shuffly")
    }
}

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.googleDevtoolsKsp) apply false
    alias(libs.plugins.jetbrainsKotlinKapt) apply false
    alias(libs.plugins.daggerHiltAndroid) apply false
    alias(libs.plugins.googleService) apply false
}