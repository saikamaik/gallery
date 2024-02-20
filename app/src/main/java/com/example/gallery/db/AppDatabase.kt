package com.example.gallery.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gallery.db.entity.Converters
import com.example.gallery.db.entity.UserDto

@Database(entities = [UserDto::class], version = 3)
@TypeConverters(
    Converters::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAppDao(): AppDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "user_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()

                return INSTANCE!!

            }
        }
    }
}