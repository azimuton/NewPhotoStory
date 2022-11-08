package com.azimuton.domain.repository

import com.azimuton.domain.models.Photo

interface PhotoRepository {
    fun getAll() : List<Photo>

    //fun delImage()

    suspend fun insertPhoto(photo: Photo)

    suspend fun deletePhoto(photo: Photo)

    //fun updatePhoto(photo: Photo)

    //fun getPhotoById(id:Int) : Photo?
}