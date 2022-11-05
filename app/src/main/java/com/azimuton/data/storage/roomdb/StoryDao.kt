package com.azimuton.data.storage.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.azimuton.data.storage.models.StoryEntity

@Dao
interface StoryDao {
    @Query("SELECT * FROM storyentity")
    fun getAllStory(): List<StoryEntity>

    @Insert
    fun insertStory(storyEntity: StoryEntity)

    @Delete
    fun deleteStory(storyEntity: StoryEntity)
}