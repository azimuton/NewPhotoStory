package com.azimuton.newphotostory.di

import android.content.Context
import com.azimuton.data.storage.roomdb.AppRoomDatabase
import com.azimuton.data.storage.roomdb.PhotoDao
import com.azimuton.data.storage.roomdb.StoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppRoomDatabase {
        return AppRoomDatabase.getDatabase(context = appContext)
    }

    @Singleton
    @Provides
    fun providePhotoDao(roomDatabase : AppRoomDatabase): PhotoDao {
        return roomDatabase.photoDao()
    }

    @Singleton
    @Provides
    fun provideStoryDao(roomDatabase : AppRoomDatabase): StoryDao {
        return roomDatabase.storyDao()
    }
}