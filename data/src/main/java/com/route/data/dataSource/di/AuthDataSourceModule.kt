package com.route.data.dataSource.di

import com.route.data.dataSource.remote.auth.AuthRemoteDataSourceImpl
import com.route.domin.dataSource.auth.AuthRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindAuthRemoteDataSource(
        authRemoteDataSourceImpl: AuthRemoteDataSourceImpl
    ): AuthRemoteDataSource

}