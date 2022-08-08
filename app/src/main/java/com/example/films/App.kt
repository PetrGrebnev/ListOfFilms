package com.example.films

import android.app.Application
import com.example.films.di.AppComponent
import com.example.films.di.AppModule
import com.example.films.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}