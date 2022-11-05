package com.azimuton.domain.models

import com.azimuton.data.storage.models.PhotoEntity

class Story (
    var dbstoryid: Int = 0,
    val dbstoryphoto: PhotoEntity
)