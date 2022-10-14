package com.example.pizzeriaapp

import android.app.Application
import com.example.pizzeriaapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
            androidLogger()
            androidContext(this@App)
        }
    }
}