package com.azimuton.data.repository

import com.azimuton.data.mappers.PhotoListMapper
import com.azimuton.data.mappers.PhotoMapper
import com.azimuton.data.storage.PhotoStorageRoom
import com.azimuton.domain.models.Photo
import com.azimuton.domain.repository.PhotoRepository

class PhotoRepositoryImpl(private  val photoStorageRoom: PhotoStorageRoom) : PhotoRepository {
    override fun getAll(): List<Photo> {
        return  PhotoListMapper().mapFromEntity(photoStorageRoom.getAll())
    }

//    override fun delImage() {
//        photoStorageRoom.delImage()
//    }

    override suspend fun insertPhoto(photo: Photo) {
        photoStorageRoom.insertPhoto(photoEntity = PhotoMapper().mapToEntity(photo))
    }

    override suspend fun deletePhoto(photo: Photo) {
        photoStorageRoom.deletePhoto(photoEntity = PhotoMapper().mapToEntity(photo))
    }

//    override fun updatePhoto(photo: Photo) {
//        photoStorageRoom.updatePhoto(photoEntity = PhotoMapper().mapToEntity(photo))
//    }
//
//    override fun getPhotoById(id: Int): Photo? {
//        return photoStorageRoom.getPhotoById(id)?.let{ PhotoMapper().mapFromEntity(it)}
//    }

}