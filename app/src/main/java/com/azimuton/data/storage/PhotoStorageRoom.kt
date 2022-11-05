package com.azimuton.data.storage

import com.azimuton.data.storage.models.PhotoEntity

interface PhotoStorageRoom {
    fun getAll(): List<PhotoEntity>

//    fun delImage()

    fun insertPhoto(photoEntity: PhotoEntity)

    fun deletePhoto(photoEntity: PhotoEntity)

//    fun updatePhoto(photoEntity: PhotoEntity)
//
//    fun getPhotoById(id: Int): PhotoEntity?
}