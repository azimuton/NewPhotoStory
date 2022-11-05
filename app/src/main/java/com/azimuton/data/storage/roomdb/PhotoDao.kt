package com.azimuton.data.storage.roomdb

import androidx.room.*
import com.azimuton.data.storage.models.PhotoEntity

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photoentity")
    fun getAll(): List<PhotoEntity>

//    @Query("DELETE FROM photoentity WHERE dbphotoentityid IN (SELECT dbphotoentityimage FROM photoentity)")
//    fun delImage()

    @Insert
    fun insertPhoto(photoEntity: PhotoEntity)

    @Delete
    fun deletePhoto(photoEntity: PhotoEntity)

//    @Update
//    fun updatePhoto(photoEntity: PhotoEntity)

//    @Query("SELECT * FROM photoentity WHERE dbphotoentityid = :id")
//    fun getPhotoById(id: Int): PhotoEntity?
}