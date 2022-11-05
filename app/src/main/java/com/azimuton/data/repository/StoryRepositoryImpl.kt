package com.azimuton.data.repository

import com.azimuton.data.mappers.StoryListMapper
import com.azimuton.data.mappers.StoryMapper
import com.azimuton.data.storage.StoryStorageRoom
import com.azimuton.domain.models.Story
import com.azimuton.domain.repository.StoryRepository

class StoryRepositoryImpl(private  val storyStorageRoom: StoryStorageRoom) : StoryRepository {
    override fun getAll(): List<Story> {
        return  StoryListMapper().mapFromEntity(storyStorageRoom.getAllStory())
    }

    override fun insertStory(story: Story) {
        storyStorageRoom.insertStory(storyEntity = StoryMapper().mapToEntity(story))
    }

    override fun deleteStory(story: Story) {
        storyStorageRoom.deleteStory(storyEntity = StoryMapper().mapToEntity(story))
    }
}