package com.example.gallery.di

import android.app.Application
import android.content.Context
import com.example.gallery.db.AppDao
import com.example.gallery.db.AppDatabase
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
    fun getRoomDBInstance() : AppDatabase {
        return AppDatabase.getDatabase(provideAppContext())
    }

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return application.applicationContext
    }
}