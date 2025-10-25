package com.it.shka.ourses_app.hilt

import com.it.shka.feature_main.data.api.ApiMainCourses
import com.it.shka.feature_auth.data.api.ApiAuthUsers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleRetrofit {
    private const val BASE_URL = "http://192.168.42.7:3700"

    @Provides
    @Singleton
    fun providerHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest: Request = chain.request()
            val requestWithHeaders = originalRequest.newBuilder()
                .header("Content-Type", "text/plain")
                .build()
            chain.proceed(requestWithHeaders)
        }
    }

    @Provides
    @Singleton
    fun providerOkHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS) // Таймаут соединения
            .readTimeout(30, TimeUnit.SECONDS)    // Таймаут чтения данных
            .writeTimeout(30, TimeUnit.SECONDS)   // Таймаут записи данных
            .build()

    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiAuthUsers {
        return retrofit.create(ApiAuthUsers::class.java)
    }
 @Provides
 @Singleton
 fun provideApiMainCourses(retrofit: Retrofit): ApiMainCourses{
     return retrofit.create(ApiMainCourses::class.java)
 }
}


