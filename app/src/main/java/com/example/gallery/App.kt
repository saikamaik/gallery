package com.example.gallery

import android.app.Application
import com.example.gallery.di.AppComponent
import com.example.gallery.di.AppModule
import com.example.gallery.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

    }

    fun getAppComponent(): AppComponent{
        return appComponent
    }

}
