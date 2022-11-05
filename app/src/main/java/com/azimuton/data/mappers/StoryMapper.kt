package com.azimuton.data.mappers

import com.azimuton.data.storage.models.StoryEntity
import com.azimuton.domain.models.Story

class StoryMapper:  StoryMapperInterface<StoryEntity, Story>  {
    override fun mapFromEntity(type: StoryEntity): Story {
        return  Story(
            dbstoryid = type.dbstoryentityid,
            dbstoryphoto = type.dbstoryentityphoto
        )
    }

    override fun mapToEntity(type: Story): StoryEntity {
        return StoryEntity(
            dbstoryentityid = type.dbstoryid,
            dbstoryentityphoto = type.dbstoryphoto
        )
    }
}