package com.it.shka.ourses_app.hilt

import com.it.shka.feature_auth.domain.RealEmailValidationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule{
    @Provides
    @Singleton
    fun provideEmailValidationUseCase(): RealEmailValidationUseCase{
        return RealEmailValidationUseCase()
    }
}