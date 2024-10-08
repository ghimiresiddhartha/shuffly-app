/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import com.android.build.gradle.internal.tasks.databinding.DataBindingGenBaseClassesTask
import org.gradle.configurationcache.extensions.capitalized
import org.jetbrains.kotlin.gradle.tasks.AbstractKotlinCompileTool

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jetbrainsKotlinKapt)
    alias(libs.plugins.googleDevtoolsKsp)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.googleService)
}

android {
    val packageName = rootProject.extra["applicationId"] as String
    val compileSdkValue = rootProject.extra["compileSdk"] as Int
    val minSdkValue = rootProject.extra["minSdk"] as Int
    val targetSdkValue = rootProject.extra["targetSdk"] as Int
    val appName = rootProject.extra["appName"] as String

    val appVersionName = rootProject.extra["versionName"] as String
    val testRunner = rootProject.extra["androidJUnitRunner"] as String
    val proguardOptimizeBasic = rootProject.extra["proguardOptimize"] as String
    val proguardOptimizePro = rootProject.extra["proguardRulesPro"] as String
    val jvmTargetVersion = rootProject.extra["jvmTargetVersion"] as String

    val buildTypeDebug = rootProject.extra["buildTypeDebug"] as String
    val buildTypeRelease = rootProject.extra["buildTypeRelease"] as String

    namespace = packageName
    compileSdk = compileSdkValue

    flavorDimensions.add(buildTypeRelease)

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }

    defaultConfig {
        applicationId = packageName
        minSdk = minSdkValue
        targetSdk = targetSdkValue
        versionCode = 1
        versionName = appVersionName

        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = testRunner
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".$buildTypeDebug"
            isMinifyEnabled = false
            isDebuggable = true
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile(proguardOptimizeBasic), proguardOptimizePro
            )
            manifestPlaceholders["appName"] = "$appName Debug"
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher"
            manifestPlaceholders["appIconRound"] = "@mipmap/ic_launcher_round"
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile(proguardOptimizeBasic), proguardOptimizePro
            )
            manifestPlaceholders["appName"] = appName
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher"
            manifestPlaceholders["appIconRound"] = "@mipmap/ic_launcher_round"
        }
    }

    productFlavors {
        create(appName) {
            dimension = buildTypeRelease
            versionCode = 1
            versionName = appVersionName

            apply(from = "./sensible-data.gradle")

            listOf(
                "BASE_URL_Y" to rootProject.ext["BASE_URL_Y"] as String?,
                "BASE_URL_T" to rootProject.ext["BASE_URL_T"] as String?,
                "BASE_URL_I" to rootProject.ext["BASE_URL_I"] as String?,
                "HEADER_T" to rootProject.ext["HEADER_T"] as String?,
                "HEADER_I" to rootProject.ext["HEADER_I"] as String?,
                "FIREBASE_ENTITY" to rootProject.ext["FIREBASE_ENTITY"] as String?,
                "SEARCH_ENDPOINT" to project.properties["SEARCH_ENDPOINT"] as String?,
                "T_TRENDING_ENDPOINT" to project.properties["T_TRENDING_ENDPOINT"] as String?,
                "I_ENDPOINT" to project.properties["I_ENDPOINT"] as String?,
                "Y_ID" to project.properties["Y_ID"] as String?,
                "Y_TYPE" to project.properties["Y_TYPE"] as String?,
                "Y_SORT_BY" to project.properties["Y_SORT_BY"] as String?,
                "Y_VIDEO_LENGTH" to project.properties["Y_VIDEO_LENGTH"] as String?,
                "Y_VIDEO_TYPE" to project.properties["Y_VIDEO_TYPE"] as String?,
                "I_HASHTAG_SEARCH" to project.properties["I_HASHTAG_SEARCH"] as String?,
                "T_SEARCH_KEYWORD" to project.properties["T_SEARCH_KEYWORD"] as String?
            ).forEach { (name, value) -> buildConfigField("String", name, "\"$value\"") }

            buildConfigField("boolean", "Y_SHOULD_SYNDICATE", "true")
            buildConfigField("boolean", "Y_SHOULD_EMBED", "true")
            buildConfigField("int", "MAX_RESULT", "20")
            buildConfigField("String", "SHARED_PREF_NAME", "\"${appName}App\"")
        }
    }

    dataBinding {
        enable = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }

    //allowing Dagger Hilt to correctly process annotations and generate the necessary code for dependency injection
    androidComponents {
        onVariants(selector().all()) { variant ->
            afterEvaluate {
                project.tasks.getByName("ksp" + variant.name.capitalized() + "Kotlin") {
                    val dataBindingTask =
                        project.tasks.getByName("dataBindingGenBaseClasses" + variant.name.capitalized()) as DataBindingGenBaseClassesTask
                    (this as AbstractKotlinCompileTool<*>).setSource(dataBindingTask.sourceOutFolder)
                }
            }
        }
    }

    kotlinOptions {
        jvmTarget = jvmTargetVersion
    }

    packaging {
        resources {
            excludes += "/META-INF/{DEPENDENCIES,LICENSE,LICENSE.txt,license.txt,LICENSE.md,LICENSE-notice.md,NOTICE,NOTICE.txt,notice.txt,ASL2.0,LGPL2.1,*.kotlin_module}"
        }
    }

    testOptions.unitTests {
        isIncludeAndroidResources = true

        all { test ->
            with(test) {
                testLogging {
                    events = setOf(
                        org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
                        org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED,
                        org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
                        org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_OUT,
                        org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_ERROR,
                    )
                }
            }
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
            freeCompilerArgs += "-opt-in=kotlin.Experimental"
        }
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