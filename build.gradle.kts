import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

val kotlinVersion = "1.4.30"
val ktorVersion = "1.5.1"
val serializationVersion = "1.0.1"

plugins {
  kotlin("multiplatform") version "1.4.30"
  kotlin("plugin.serialization") version "1.4.0"
  application
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
  mavenLocal()
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
  js(LEGACY) {
    binaries.executable()
    browser {
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
    val commonMain by getting {
      dependencies {
        implementation(kotlin("stdlib-common"))
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
        implementation("io.ktor:ktor-client-core:$ktorVersion")
      }
    }
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
        implementation("io.ktor:ktor-html-builder:$ktorVersion")
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
        implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.2")
        implementation("org.jetbrains:kotlin-styled:5.2.0-pre.144-kotlin-$kotlinVersion")

        implementation("org.jetbrains:kotlin-react:17.0.1-pre.144-kotlin-$kotlinVersion")
        implementation("org.jetbrains:kotlin-react-dom:17.0.1-pre.144-kotlin-$kotlinVersion")
        implementation("org.jetbrains:kotlin-react-router-dom:5.2.0-pre.144-kotlin-$kotlinVersion")
        implementation("org.jetbrains:kotlin-react-redux:7.2.1-pre.144-kotlin-$kotlinVersion")
        implementation("org.jetbrains:kotlin-redux:4.0.5-pre.144-kotlin-$kotlinVersion")

        implementation("io.ktor:ktor-client-js:$ktorVersion")
        implementation("io.ktor:ktor-client-json-js:$ktorVersion")
        implementation("io.ktor:ktor-client-serialization-js:$ktorVersion")
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
val isDevelopment = System.getenv().get("io.ktor.development") == "true"
val webpackTaskName = "jsBrowser${if(isDevelopment) "Development" else "Production"}Webpack"
val webpackTask = tasks.getByName<KotlinWebpack>(webpackTaskName)

tasks.getByName<Jar>("jvmJar") {
  dependsOn(webpackTask)
  from(File(webpackTask.destinationDirectory, webpackTask.outputFileName))
  if(isDevelopment) {
    from(File(webpackTask.destinationDirectory, webpackTask.outputFileName + ".map"))
  }
}

tasks.getByName<JavaExec>("run") {
  dependsOn(tasks.getByName<Jar>("jvmJar"))
  classpath(tasks.getByName<Jar>("jvmJar"))
}
kotlin {
  js(LEGACY) {
    browser {
      runTask {
        val contentDir = File(projectDir, "src/jvmMain/resources").absolutePath
        devServer = KotlinWebpackConfig.DevServer(contentBase = listOf(contentDir), open=false)
      }
    }
  }
}

tasks.create<Jar>("fatJar") {
  manifest {
    attributes["Main-Class"] = application.mainClassName
  }
  from(Callable { configurations["runtimeClasspath"].map { if (it.isDirectory) it else zipTree(it) } })
  val jvmJar = tasks["jvmJar"]
  dependsOn(jvmJar)
  with(jvmJar as CopySpec)
}