package com.azimuton.newphotostory.di

import com.azimuton.domain.repository.PhotoRepository
import com.azimuton.domain.repository.StoryRepository
import com.azimuton.domain.usecase.DeleteUseCase
import com.azimuton.domain.usecase.GetAllUseCase
import com.azimuton.domain.usecase.InsertUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideDeleteUseCase(photoRepository: PhotoRepository, storyRepository: StoryRepository): DeleteUseCase {
        return  DeleteUseCase(photoRepository = photoRepository, storyRepository = storyRepository)
    }
    @Provides
    fun provideInsertUseCase(photoRepository: PhotoRepository, storyRepository: StoryRepository): InsertUseCase {
        return InsertUseCase(photoRepository = photoRepository, storyRepository = storyRepository)
    }
    @Provides
    fun provideGetAllUseCase(photoRepository: PhotoRepository, storyRepository: StoryRepository): GetAllUseCase{
        return GetAllUseCase(photoRepository = photoRepository, storyRepository = storyRepository)
    }
}