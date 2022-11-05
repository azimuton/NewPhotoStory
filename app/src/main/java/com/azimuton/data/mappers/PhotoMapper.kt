package com.azimuton.data.mappers

import com.azimuton.data.storage.models.PhotoEntity
import com.azimuton.domain.models.Photo

class PhotoMapper : PhotoMapperInterface<PhotoEntity, Photo> {
    override fun mapFromEntity(type: PhotoEntity): Photo {
        return Photo( dbphotoid = type.dbphotoentityid,
            dbphototitle = type.dbphotoentitytitle,
            dbphotocontent = type.dbphotoentitycontent,
            dbphotoimage = type.dbphotoentityimage,)
    }

    override fun mapToEntity(type: Photo): PhotoEntity {
        return PhotoEntity(dbphotoentityid = type.dbphotoid,
            dbphotoentitytitle = type.dbphototitle,
            dbphotoentitycontent = type.dbphotocontent,
            dbphotoentityimage = type.dbphotoimage,)
    }
}