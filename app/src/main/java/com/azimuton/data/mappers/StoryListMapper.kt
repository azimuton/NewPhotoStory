package com.azimuton.data.mappers

import com.azimuton.data.storage.models.StoryEntity
import com.azimuton.domain.models.Story

class StoryListMapper: StoryMapperInterface<List<StoryEntity>, List<Story>> {
    override fun mapFromEntity(type: List<StoryEntity>): List<Story> {
        val listStory = ArrayList<Story>()

        type.forEach { storyEntity ->
            listStory.add(
                Story(
                    dbstoryid = storyEntity.dbstoryentityid,
                    dbstoryphoto = storyEntity.dbstoryentityphoto
                )
            )
        }

        return listStory.toList()
    }

    override fun mapToEntity(type: List<Story>): List<StoryEntity> {
        val listStoryEntity = ArrayList<StoryEntity>()

        type.forEach { story ->
            listStoryEntity.add(
                StoryEntity(
                    dbstoryentityid = story.dbstoryid,
                    dbstoryentityphoto = story.dbstoryphoto
                )
            )
        }

        return listStoryEntity.toList()
    }
}