package com.example.staggeredgrid.di

import com.example.staggeredgrid.data.repository.RepositoryImpl
import com.example.staggeredgrid.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
	/*@Binds
	abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository*/
}