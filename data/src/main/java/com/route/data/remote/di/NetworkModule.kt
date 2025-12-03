package com.route.data.remote.di

import android.util.Log
import com.route.data.remote.TokenProvider
import com.route.data.remote.api.AuthService
import com.route.data.remote.api.CategoryService
import com.route.data.remote.api.ProductsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesTokenInterceptor(tokenProvider: TokenProvider): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val token = tokenProvider.token

            val newRequest = if (token != null) {
                originalRequest.newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
            } else {
                originalRequest
            }

            chain.proceed(newRequest)
        }
    }

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor {
            Log.e("ApiManager", it)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        tokenInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(tokenInterceptor)
            .build()

    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun providesRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://ecommerce.routemisr.com/api/v1/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

    }

    @Provides
    @Singleton
    fun providesAuthService(retrofit: Retrofit): AuthService{
        return retrofit.create(AuthService::class.java)
    }
    @Provides
    @Singleton
    fun providesCategoryService(retrofit: Retrofit): CategoryService{
        return retrofit.create(CategoryService::class.java)
    }
    @Provides
    @Singleton
    fun providesProductsService(retrofit: Retrofit): ProductsService{
        return retrofit.create(ProductsService::class.java)
    }

}