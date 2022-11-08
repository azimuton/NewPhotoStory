package com.azimuton.domain.usecase

import com.azimuton.domain.models.Photo
import com.azimuton.domain.models.Story
import com.azimuton.domain.repository.PhotoRepository
import com.azimuton.domain.repository.StoryRepository

class InsertUseCase(private val photoRepository: PhotoRepository,
                    private val storyRepository: StoryRepository
) {
    suspend fun photoExecute(photo:Photo){
        return  photoRepository.insertPhoto(photo = photo)
    }
    fun storyExecute(story: Story){
        return  storyRepository.insertStory(story = story)
    }
}