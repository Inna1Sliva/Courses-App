package com.it.shka.ourses_app.hilt

import com.it.shka.core.database.AppDatabase
import com.it.shka.feature_main.data.repository.MainCoursesRepositoryImp
import com.it.shka.feature_main.data.api.ApiMainCourses
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
    fun provideAuthUserRepository(apiService: ApiAuthUsers, database:AppDatabase): AuthUserRepositoryImp{
       return AuthUserRepositoryImp(apiService, database)
     }
    @Provides
    @Singleton
    fun provideMainCoursesRepository(apiMainCourses: ApiMainCourses, database: AppDatabase): MainCoursesRepositoryImp{
        return MainCoursesRepositoryImp(apiMainCourses,database )
    }

}