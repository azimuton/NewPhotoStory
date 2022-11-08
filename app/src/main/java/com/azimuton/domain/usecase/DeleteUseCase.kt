package com.azimuton.domain.usecase

import com.azimuton.domain.models.Photo
import com.azimuton.domain.models.Story
import com.azimuton.domain.repository.PhotoRepository
import com.azimuton.domain.repository.StoryRepository

class DeleteUseCase(private val photoRepository: PhotoRepository,
                    private val storyRepository: StoryRepository
) {
    suspend fun photoExecute(photo: Photo){
        return  photoRepository.deletePhoto(photo = photo)
    }
    fun storyExecute(story: Story){
        return  storyRepository.deleteStory(story = story)
    }
}