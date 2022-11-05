package com.azimuton.domain.usecase

import com.azimuton.domain.models.Photo
import com.azimuton.domain.models.Story
import com.azimuton.domain.repository.PhotoRepository
import com.azimuton.domain.repository.StoryRepository

class GetAllUseCase(private val photoRepository: PhotoRepository,
                    private val storyRepository: StoryRepository) {
    fun photoExecute():List<Photo>{
        return  photoRepository.getAll()
    }
    fun storyExecute():List<Story>{
        return  storyRepository.getAll()
    }
}