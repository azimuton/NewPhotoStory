package com.azimuton.data.storage

import com.azimuton.data.storage.models.PhotoEntity
import com.azimuton.data.storage.roomdb.PhotoDao


class PhotoStorageRoomImpl(private  val photoDao: PhotoDao) : PhotoStorageRoom {
    override fun getAll(): List<PhotoEntity> {
        return  photoDao.getAll()
    }

//    override fun delImage() {
//        photoDao.delImage()
//    }

    override fun insertPhoto(photoEntity: PhotoEntity) {
        photoDao.insertPhoto(photoEntity)
    }

    override fun deletePhoto(photoEntity: PhotoEntity) {
        photoDao.deletePhoto(photoEntity)
    }

//    override fun updatePhoto(photoEntity: PhotoEntity) {
//        photoDao.updatePhoto(photoEntity)
//    }
//
//    override fun getPhotoById(id: Int): PhotoEntity? {
//        return  photoDao.getPhotoById(id)
//    }

}