package com.azimuton.data.storage

import com.azimuton.data.storage.models.StoryEntity

interface StoryStorageRoom {
    fun getAllStory(): List<StoryEntity>

    fun insertStory(storyEntity: StoryEntity)

    fun deleteStory(storyEntity: StoryEntity)
}