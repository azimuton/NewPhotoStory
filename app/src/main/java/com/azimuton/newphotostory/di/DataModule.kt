package com.azimuton.newphotostory.di

import com.azimuton.data.repository.PhotoRepositoryImpl
import com.azimuton.data.repository.StoryRepositoryImpl
import com.azimuton.data.storage.PhotoStorageRoom
import com.azimuton.data.storage.PhotoStorageRoomImpl
import com.azimuton.data.storage.StoryStorageRoom
import com.azimuton.data.storage.StoryStorageRoomImpl
import com.azimuton.data.storage.roomdb.PhotoDao
import com.azimuton.data.storage.roomdb.StoryDao
import com.azimuton.domain.repository.PhotoRepository
import com.azimuton.domain.repository.StoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun providePhotoStorageRoom(photoDao: PhotoDao): PhotoStorageRoom {
        return PhotoStorageRoomImpl(photoDao = photoDao)
    }

    @Singleton
    @Provides
    fun providePhotoRepository(photoStorage: PhotoStorageRoom): PhotoRepository {
        return  PhotoRepositoryImpl(photoStorageRoom = photoStorage)
    }

    @Singleton
    @Provides
    fun provideStoryStorageRoom(storyDao: StoryDao): StoryStorageRoom {
        return StoryStorageRoomImpl(storyDao = storyDao)
    }

    @Singleton
    @Provides
    fun provideStoryRepository(storyStorage: StoryStorageRoom): StoryRepository {
        return  StoryRepositoryImpl(storyStorageRoom = storyStorage)
    }
}