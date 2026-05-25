package com.it.shka.ourses_app.hilt

import com.it.shka.core.data.AppDatabase
import com.it.shka.feature_main.data.repository.MainRemoteDataSourceRepositoryImp
import com.it.shka.feature_main.data.api.ApiMainCourses
import com.it.shka.feature_auth.data.repository.AuthRemoteDataSourceRepositoryImp
import com.it.shka.feature_auth.data.api.ApiAuthUsers
import com.it.shka.feature_auth.data.repository.AuthLocalDataSourceRepositoryImp
import com.it.shka.feature_auth.domain.repository.AuthLocalDataSourceRepository
import com.it.shka.feature_auth.domain.repository.AuthRemoteDataSourceRepository
import com.it.shka.feature_bottom_nav.data.api.ApiServerBottomNav
import com.it.shka.feature_bottom_nav.data.repository.BottomNavLocalDataSourceRepositoryImpl
import com.it.shka.feature_bottom_nav.data.repository.BottomNavRemoteDataSourceRepositoryImp
import com.it.shka.feature_bottom_nav.domain.repository.BottomNavLocalDataSourceRepository
import com.it.shka.feature_bottom_nav.domain.repository.BottomNavRemoteDataSourceRepository
import com.it.shka.feature_favorites.data.DataFavoritesRepositoryImpl
import com.it.shka.feature_favorites.domain.repository.DataFavoritesRepository
import com.it.shka.feature_main.data.repository.MainLocalDataSourceRepositoryImp
import com.it.shka.feature_main.domain.MainRemoteDataSourceRepository
import com.it.shka.feature_main.domain.MainLocalDataSourceRepository
import com.it.shka.feature_profile.data.ProfileLocalDataSourceRepositoryImp
import com.it.shka.feature_profile.data.ProfileUserRepositoryImp
import com.it.shka.feature_profile.data.api.ApiProfileCourses
import com.it.shka.feature_profile.domain.ProfileLocalDataSourceRepository
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
    fun provideAuthRemoteDataSourceRepository(apiService: ApiAuthUsers): AuthRemoteDataSourceRepository {
       return AuthRemoteDataSourceRepositoryImp(apiService)
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
    fun provideDataBottomNavRepository(database:AppDatabase): BottomNavLocalDataSourceRepository{
        return BottomNavLocalDataSourceRepositoryImpl(database)
    }
    @Provides
    @Singleton
    fun provideBottomNavRemoteDataSourceRepository(api: ApiServerBottomNav): BottomNavRemoteDataSourceRepository {
        return BottomNavRemoteDataSourceRepositoryImp(api)
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
    @Provides
    @Singleton
    fun provideAuthLocalDataSourceRepository(database:AppDatabase): AuthLocalDataSourceRepository {
        return AuthLocalDataSourceRepositoryImp(database)
    }
    @Provides
    @Singleton
    fun provideProfileLocalDataSourceRepository(database:AppDatabase): ProfileLocalDataSourceRepository {
        return ProfileLocalDataSourceRepositoryImp(database)
    }


}