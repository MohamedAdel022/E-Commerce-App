package com.route.data.repository.di

import com.route.data.repository.home.HomeRepositoryImpl
import com.route.domin.repository.home.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface HomeModule {
    @Binds
    @Singleton
    abstract  fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
}