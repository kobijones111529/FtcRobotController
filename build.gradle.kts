/**
 * Top-level build file for ftc_app project.
 *
 * It is extraordinarily rare that you will ever need to edit this file.
 */

val doc: Configuration by configurations.creating {
    isTransitive = false
}

buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
    }
}

repositories {
    mavenCentral()
}

dependencies {
    doc("org.firstinspires.ftc:Hardware:7.1.0")
    doc("org.firstinspires.ftc:RobotCore:7.1.0")
    doc("org.firstinspires.ftc:FtcCommon:7.1.0")
    doc("org.firstinspires.ftc:OnBotJava:7.1.0")
    doc("org.firstinspires.ftc:Inspection:7.1.0")
}

// Can't figure this out
val extractJavadoc: TaskProvider<Task> by tasks.registering {
    doLast {
        val componentIds = doc.incoming.resolutionResult.allDependencies.map { it.from.id }
        val result = dependencies
            .createArtifactResolutionQuery()
            .forComponents(componentIds)
            .withArtifacts(JvmLibrary::class, SourcesArtifact::class, JavadocArtifact::class)
            .execute()
        result.resolvedComponents.forEach { component ->
            component.getArtifacts(JavadocArtifact::class).forEach { _ ->
                TODO()
            }
        }
    }
}
