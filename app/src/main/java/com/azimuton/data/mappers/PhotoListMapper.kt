package com.azimuton.data.mappers

import com.azimuton.data.storage.models.PhotoEntity
import com.azimuton.domain.models.Photo

class PhotoListMapper: PhotoMapperInterface<List<PhotoEntity>, List<Photo>> {

    override fun mapFromEntity(type: List<PhotoEntity>): List<Photo> {
        val listPhoto = ArrayList<Photo>()

        type.forEach { photoEntity ->
            listPhoto.add(
                Photo(
                    dbphotoid = photoEntity.dbphotoentityid,
                    dbphototitle = photoEntity.dbphotoentitytitle,
                    dbphotocontent = photoEntity.dbphotoentitycontent,
                    dbphotoimage = photoEntity.dbphotoentityimage,
                )
            )
        }
        return listPhoto.toList()
    }

    override fun mapToEntity(type: List<Photo>): List<PhotoEntity> {
        val listPhotoEntity = ArrayList<PhotoEntity>()

        type.forEach { photo ->
            listPhotoEntity.add(
                PhotoEntity(
                    dbphotoentityid = photo.dbphotoid,
                    dbphotoentitytitle = photo.dbphototitle,
                    dbphotoentitycontent = photo.dbphotocontent,
                    dbphotoentityimage = photo.dbphotoimage,
                )
            )
        }
        return listPhotoEntity.toList()
    }
}