package com.example.gallery.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.gallery.db.AppDao
import com.example.gallery.db.AppDatabase
import com.example.gallery.db.DatabaseRepository
import com.example.gallery.db.DatabaseRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val application: Application
) {

    @Singleton
    @Provides
    fun getAppDao(appDatabase: AppDatabase): AppDao {
        return appDatabase.getAppDao()
    }

    @Singleton
    @Provides
    fun getRoomDBInstance(
        context: Context
    ) = Room.databaseBuilder(context, AppDatabase::class.java, "user_db")
        .fallbackToDestructiveMigration().allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun getDBRepository(): DatabaseRepository {
        return DatabaseRepositoryImpl(getAppDao(getRoomDBInstance(provideAppContext())))
    }

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return application.applicationContext
    }
}