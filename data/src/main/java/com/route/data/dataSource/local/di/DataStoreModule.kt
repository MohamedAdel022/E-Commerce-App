package com.route.data.dataSource.local.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.route.data.dataSource.local.dataStore.PrefsHelperImpl
import com.route.data.remote.TokenProvider
import com.route.domin.localStorage.PrefsHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    val PREFS_NAME = "e-commerce prefs"
     val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFS_NAME)

    @Provides
    @Singleton
    fun providePreferencesDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.dataStore
    }

    @Provides
    @Singleton
    fun providePrefsHelper(dataStore: DataStore<Preferences>, tokenProvider: TokenProvider): PrefsHelper {
        return PrefsHelperImpl(dataStore, tokenProvider)

    }
}


