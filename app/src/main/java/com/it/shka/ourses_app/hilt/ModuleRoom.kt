package com.it.shka.ourses_app.hilt

import android.content.Context
import androidx.room.Room
import com.it.shka.core.data.database.AppDatabase
import com.it.shka.feature_onboarding.data.database.AppUserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleRoom {
@Singleton
@Provides
fun providesRoomDatabase(@ApplicationContext context: Context): AppDatabase {
    return Room.databaseBuilder(context = context, klass = AppDatabase::class.java, name = "courses_favorites" )
        .build()
}
    @Singleton
    @Provides
    fun providesDatabaseUserId(@ApplicationContext context: Context): AppUserDatabase{
        return Room.databaseBuilder(context = context, klass = AppUserDatabase::class.java, name = "user_Id")
            .build()
    }
}