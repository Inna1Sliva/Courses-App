package com.it.shka.ourses_app.hilt

import android.content.Context
import androidx.room.Room
import com.it.shka.core.database.data.AppDatabase
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
    return Room.databaseBuilder(context = context, klass = AppDatabase::class.java, name = "courses_app" )
        .build()
}
   // @Singleton
   // @Provides
   // fun providesDatabaseUserId(@ApplicationContext context: Context): AppUserDatabase{
    //    return Room.databaseBuilder(context = context, klass = AppUserDatabase::class.java, name = "user_Id")
    //        .build()
    //}
  //  @Singleton
   // @Provides
   // fun providesDatabaseUser(@ApplicationContext context: Context): AppUserIdDatabase{
    //    return Room.databaseBuilder(context = context, klass = AppUserIdDatabase::class.java, name = "user_Id")
   //         .build()
  //  }
}