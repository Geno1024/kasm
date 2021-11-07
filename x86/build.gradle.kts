plugins {
    kotlin("multiplatform") version "1.5.31"
}

repositories {
    mavenCentral()
}

kotlin {
    linuxX64()
    mingwX64()
}
