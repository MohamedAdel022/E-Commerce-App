package com.route.data.dataSource.di

import com.route.domin.dataSource.home.HomeRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindHomeRemoteDataSource(
        homeRemoteDataSourceImpl: HomeRemoteDataSource
    ): HomeRemoteDataSource

}