package com.it.shka.ourses_app.hilt

import com.it.shka.core.data.AppDatabase
import com.it.shka.feature_main.data.repository.MainRemoteDataSourceRepositoryImp
import com.it.shka.feature_main.data.api.ApiMainCourses
import com.it.shka.feature_auth.data.repository.AuthUserRepositoryImp
import com.it.shka.feature_auth.data.api.ApiAuthUsers
import com.it.shka.feature_bottom_nav.data.DataBottomNavRepositoryImpl
import com.it.shka.feature_bottom_nav.domain.repository.DataBottomNavRepository
import com.it.shka.feature_favorites.data.DataFavoritesRepositoryImpl
import com.it.shka.feature_favorites.domain.repository.DataFavoritesRepository
import com.it.shka.feature_main.data.repository.MainLocalDataSourceRepositoryImp
import com.it.shka.feature_main.domain.MainRemoteDataSourceRepository
import com.it.shka.feature_main.domain.MainLocalDataSourceRepository
import com.it.shka.feature_profile.data.ProfileUserRepositoryImp
import com.it.shka.feature_profile.data.api.ApiProfileCourses
import com.it.shka.feature_profile.domain.ProfileUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
     @Provides
     @Singleton
    fun provideAuthUserRepository(apiService: ApiAuthUsers, database:AppDatabase): AuthUserRepositoryImp{
       return AuthUserRepositoryImp(apiService, database)
     }
    @Provides
    @Singleton
    fun provideMainCoursesRepository(apiMainCourses: ApiMainCourses, mainLocalDataSourceRepository: MainLocalDataSourceRepository): MainRemoteDataSourceRepository {
        return MainRemoteDataSourceRepositoryImp(apiMainCourses, mainLocalDataSourceRepository)
    }
    @Provides
    @Singleton
    fun provideMainLocalDataSourceRepository( database:AppDatabase): MainLocalDataSourceRepository {
        return MainLocalDataSourceRepositoryImp(database)
    }
    @Provides
    @Singleton
    fun provideDataBottomNavRepository(database:AppDatabase): DataBottomNavRepository{
        return DataBottomNavRepositoryImpl(database)
    }
    @Provides
    @Singleton
    fun provideDataFavoritesRepository(database:AppDatabase): DataFavoritesRepository {
        return DataFavoritesRepositoryImpl(database)
    }
    @Provides
    @Singleton
    fun provideProfileUserRepository(apiMainCourses: ApiProfileCourses): ProfileUserRepository {
        return ProfileUserRepositoryImp(apiMainCourses)
    }


}