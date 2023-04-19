plugins {
    //trick: for the same plugin versions in all sub-modules
    kotlin("multiplatform").version("1.8.10").apply(false)
    id("com.android.library").version("8.0.0").apply(false)
    id("org.jetbrains.kotlin.android").version("1.8.20").apply(false)
    id("org.jetbrains.compose").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
