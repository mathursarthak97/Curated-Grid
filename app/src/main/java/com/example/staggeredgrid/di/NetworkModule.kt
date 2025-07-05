package com.example.staggeredgrid.di

import com.example.staggeredgrid.data.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	@Provides
	@Singleton
	fun provideLoggingInterceptor(): HttpLoggingInterceptor {
		return HttpLoggingInterceptor().setLevel(
			level = HttpLoggingInterceptor.Level.BODY
		)
	}

	@Provides
	@Singleton
	fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
		return OkHttpClient
			.Builder()
			.addInterceptor(loggingInterceptor)
			.readTimeout(15, TimeUnit.SECONDS)
			.connectTimeout(15, TimeUnit.SECONDS)
			.build()
	}

	@Provides
	@Singleton
	fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

	@Provides
	@Singleton
	fun provideRetrofit(
		okHttpClient: OkHttpClient,
		converterFactory: GsonConverterFactory,
		baseUrl: String
	): Retrofit {
		return Retrofit
			.Builder()
			.client(okHttpClient)
			.addConverterFactory(converterFactory)
			.baseUrl("")
			.build()
	}

	@Provides
	@Singleton
	fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}