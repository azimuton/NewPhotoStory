package com.azimuton.data.storage

import com.azimuton.data.storage.models.StoryEntity
import com.azimuton.data.storage.roomdb.StoryDao

class StoryStorageRoomImpl(private val storyDao: StoryDao) : StoryStorageRoom {
    override fun getAllStory(): List<StoryEntity> {
        return  storyDao.getAllStory()
    }

    override fun insertStory(storyEntity: StoryEntity) {
        storyDao.insertStory(storyEntity)
    }

    override fun deleteStory(storyEntity: StoryEntity) {
        storyDao.deleteStory(storyEntity)
    }
}