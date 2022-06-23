//
// build.gradle in TeamCode
//
// Most of the definitions for building your module reside in a common, shared
// file 'build.common.gradle'. Being factored in this way makes it easier to
// integrate updates to the FTC into your code. If you really need to customize
// the build definitions, you can place those customizations in this file, but
// please think carefully as to whether such customizations are really necessary
// before doing so.


// Custom definitions may go here

apply(from = "../build.common.gradle")
apply(from = "../build.dependencies.gradle")

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    androidResources {
        noCompress("tflite")
    }

    packagingOptions {
        jniLibs {
            pickFirsts.add("**/*.so")
        }
    }
}

dependencies {
    implementation(project(":FtcRobotController"))
    annotationProcessor(files("lib/OpModeAnnotationProcessor.jar"))
}
