package com.azimuton.domain.repository

import com.azimuton.domain.models.Story

interface StoryRepository {
    fun getAll() : List<Story>

    fun insertStory(story : Story)

    fun deleteStory(story : Story)
}