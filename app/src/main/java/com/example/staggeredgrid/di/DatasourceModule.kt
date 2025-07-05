package com.example.staggeredgrid.di

import com.example.staggeredgrid.data.datasource.RemoteDatasource
import com.example.staggeredgrid.data.datasource.RemoteDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DatasourceModule {
	/*@Binds
	abstract fun bindsRemoteDatasource(remoteDatasourceImpl: RemoteDatasourceImpl): RemoteDatasource*/
}