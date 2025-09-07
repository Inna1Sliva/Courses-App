package com.it.shka.ourses_app.hilt

import androidx.room.Database
import androidx.room.RoomDatabase
import com.it.shka.core.data.repository.MainCoursesRepositoryImp
import com.it.shka.core.data.api.ApiMainCourses
import com.it.shka.core.data.database.AppDatabase
import com.it.shka.feature_auth.data.repository.AuthUserRepositoryImp
import com.it.shka.feature_auth.data.api.ApiAuthUsers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleNetwork {
     @Provides
     @Singleton
    fun provideAuthUserRepository(apiService: ApiAuthUsers): AuthUserRepositoryImp{
       return AuthUserRepositoryImp(apiService)
     }
    @Provides
    @Singleton
    fun provideMainCoursesRepository(apiMainCourses: ApiMainCourses, database: AppDatabase): MainCoursesRepositoryImp{
        return MainCoursesRepositoryImp(apiMainCourses,database )
    }

}