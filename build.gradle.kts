buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(GradlePlugins.ANDROID)
        classpath(GradlePlugins.KOTLIN)
        classpath(GradlePlugins.DAGGER)
        classpath(GradlePlugins.SERIALIZATION)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}