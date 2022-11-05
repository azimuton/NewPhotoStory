package com.azimuton.data.storage.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.azimuton.data.storage.models.PhotoEntity
import com.azimuton.data.storage.models.StoryEntity

@Database(entities = [PhotoEntity::class, StoryEntity::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao
    abstract fun storyDao(): StoryDao


    companion object {
        @Volatile
        private var INSTANCE: AppRoomDatabase? = null


        fun getDatabase(context: Context): AppRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "photo_database")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}