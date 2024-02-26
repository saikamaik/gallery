package com.example.gallery.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gallery.db.entity.PhotoDto
import com.example.gallery.db.entity.UserDto
import com.example.gallery.utils.Converters

@Database(entities = [UserDto::class, PhotoDto::class], version = 5)
@TypeConverters(
    Converters::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAppDao(): AppDao
}