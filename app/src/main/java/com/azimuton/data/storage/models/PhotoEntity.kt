package com.azimuton.data.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true)
    var dbphotoentityid: Int = 0,
    val dbphotoentitytitle: String,
    val dbphotoentitycontent: String,
    val dbphotoentityimage: String
)
