package com.azimuton.data.storage.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StoryEntity(
    @PrimaryKey(autoGenerate = true)
    var dbstoryentityid: Int = 0,
    @Embedded
    val dbstoryentityphoto: PhotoEntity
)
