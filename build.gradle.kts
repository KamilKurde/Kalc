plugins {
	java
	kotlin("multiplatform") version "1.4.32"
	`maven-publish`
}

group = "com.KamilKurde"
version = "0.1.0"

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION))
}

kotlin {
	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = "1.8"
		}
	}
	js(LEGACY) {
		browser {
			testTask {
				//enabled = false
				useKarma {
					useIe()
				}
			}
		}
		binaries.executable()
	}

	val hostOs = System.getProperty("os.name")
	val isMingwX64 = hostOs.startsWith("Windows")
	val nativeTarget = when
	{
		hostOs == "Mac OS X" -> macosX64("native")
		hostOs == "Linux"    -> linuxX64("native")
		isMingwX64           -> mingwX64("native")
		else                 -> throw GradleException("Host OS is not supported in Kotlin/Native.")
	}


	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(kotlin("stdlib"))
				implementation("com.ionspin.kotlin:bignum:0.2.8")
			}
		}
		val commonTest by getting {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}
		val jvmMain by getting
		val jvmTest by getting {
			dependencies {
				implementation(kotlin("test-junit5"))
				implementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
				runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
			}
		}
		val jsMain by getting {
			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}
		val jsTest by getting {
			dependencies {
				implementation(kotlin("test-js"))
			}
		}
		val nativeMain by getting
		dependencies {
			implementation(kotlin("stdlib"))
		}
		val nativeTest by getting
	}
}

extensions.findByName("buildScan")?.withGroovyBuilder {
	setProperty("termsOfServiceUrl", "https://gradle.com/terms-of-service")
	setProperty("termsOfServiceAgree", "yes")
}