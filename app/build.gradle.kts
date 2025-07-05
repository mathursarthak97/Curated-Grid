plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.hilt.android)
	alias(libs.plugins.kotlin.ksp)
	alias(libs.plugins.kotlin.parcelize)
}

android {
	namespace = "com.example.staggeredgrid"
	compileSdk = 35

	defaultConfig {
		applicationId = "com.example.staggeredgrid"
		minSdk = 24
		targetSdk = 35
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	kotlinOptions {
		jvmTarget = "11"
	}

	buildFeatures {
		buildConfig = true
		viewBinding = true
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.fragment)
	implementation(libs.androidx.constraintlayout)

	// Retrofit
	implementation(libs.retrofit)

	// Gson
	implementation(libs.converter.gson)

	// OkHttpInterceptor
	implementation(libs.logging.interceptor)

	// Glide
	implementation(libs.glide)

	// ViewModel
	implementation(libs.androidx.lifecycle.viewmodel.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)

	// Coroutines
	implementation(libs.kotlinx.coroutines.android)

	// Hilt
	implementation(libs.hilt.android)
	ksp(libs.hilt.compiler)

	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}