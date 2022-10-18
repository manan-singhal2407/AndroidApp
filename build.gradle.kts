buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Classpath.gradle)
        classpath(Classpath.kotlinPlugin)
        classpath(Classpath.hilt)
        classpath(Classpath.junit5)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven( "https://jitpack.io" )
    }
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}