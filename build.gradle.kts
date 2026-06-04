// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    //add firebase sdk
    id("com.google.gms.google-services") version "4.4.4" apply false
    //add dagger hilt
    id("com.google.devtools.ksp") version "2.3.9" apply false
    id("com.google.dagger.hilt.android") version "2.59.2" apply false
}