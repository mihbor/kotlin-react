import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack

val ktorVersion = "1.4.0"

plugins {
  kotlin("multiplatform") version "1.4.10"
  kotlin("plugin.serialization") version "1.4.0"
  application
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  jcenter()
  maven { setUrl("https://dl.bintray.com/kotlin/ktor") }
  maven { setUrl("https://dl.bintray.com/kotlin/kotlinx") }
  maven { setUrl("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
  maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
}

kotlin {
  jvm {
    compilations.all {
      kotlinOptions.jvmTarget = "1.8"
    }
    withJava()
  }
  js {
    browser {
      binaries.executable()
      webpackTask {
        cssSupport.enabled = true
      }
      runTask {
        cssSupport.enabled = true
      }
      testTask {
        useKarma {
          useChromeHeadless()
          webpackConfig.cssSupport.enabled = true
        }
      }
    }
  }
  sourceSets {
    val commonMain by getting
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }
    val jvmMain by getting {
      dependencies {
        implementation("io.ktor:ktor-serialization:$ktorVersion")
        implementation("io.ktor:ktor-server-core:$ktorVersion")
        implementation("io.ktor:ktor-server-netty:$ktorVersion")
        implementation("ch.qos.logback:logback-classic:1.2.3")
        implementation("io.ktor:ktor-websockets:$ktorVersion")
        implementation("io.ktor:ktor-html-builder:1.4.0")
        implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
      }
    }
    val jvmTest by getting {
      dependencies {
        implementation(kotlin("test-junit"))
      }
    }
    val jsMain by getting {
      dependencies {
        implementation("io.ktor:ktor-client-js:$ktorVersion")
        implementation("io.ktor:ktor-client-json-js:$ktorVersion")
        implementation("io.ktor:ktor-client-serialization-js:$ktorVersion")

        implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.2")
        implementation("org.jetbrains:kotlin-react:16.13.1-pre.110-kotlin-1.4.10")
        implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.110-kotlin-1.4.10")
        implementation("org.jetbrains:kotlin-styled:1.0.0-pre.110-kotlin-1.4.10")
        implementation(npm("react", "16.13.1"))
        implementation(npm("react-dom", "16.13.1"))
      }
    }
    val jsTest by getting {
      dependencies {
        implementation(kotlin("test-js"))
      }
    }
  }
}

application {
  mainClassName = "ServerKt"
}

distributions {
  main {
    contents {
      from("$buildDir/libs") {
        rename("${rootProject.name}-jvm", rootProject.name)
        into("lib")
      }
    }
  }
}

tasks.create("stage") {
  dependsOn(tasks.getByName("installDist"))
}

tasks.getByName<Jar>("jvmJar") {
  val taskName = if (project.hasProperty("isProduction")) {
    "jsBrowserProductionWebpack"
  } else {
    "jsBrowserDevelopmentWebpack"
  }
  val jsBrowserWebpack = tasks.getByName<KotlinWebpack>(taskName) {
    outputFileName = "scripts.js"
  }
  dependsOn(jsBrowserWebpack)
  from(File(jsBrowserWebpack.destinationDirectory, jsBrowserWebpack.outputFileName))
}

tasks.create<Jar>("fatJar") {
  manifest {
    attributes["Main-Class"] = application.mainClassName
  }
  from(Callable { configurations["runtimeClasspath"].map { if (it.isDirectory) it else zipTree(it) } })
  with(tasks["jvmJar"] as CopySpec)
}
tasks.getByName<JavaExec>("run") {
  dependsOn(tasks.getByName<Jar>("jvmJar"))
  classpath(tasks.getByName<Jar>("jvmJar"))
}