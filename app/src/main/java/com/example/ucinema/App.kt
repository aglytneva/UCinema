package com.example.ucinema

import android.app.Application
import com.example.ucinema.di.netWorkModule
import com.example.ucinema.feature.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(netWorkModule, mainScreenModule)
        }

    }
}