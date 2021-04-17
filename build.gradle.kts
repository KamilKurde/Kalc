plugins {
	java
	kotlin("multiplatform") version "1.4.32"
}

group = "com.github.KamilKurde"
version = "0.1"

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))
}

kotlin {
	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = "1.6"
		}
	}
	js(IR) {
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
		val jsMain by getting
		val jsTest by getting {
			dependencies {
				implementation(kotlin("test-js"))
			}
		}
		val nativeMain by getting
	}
}