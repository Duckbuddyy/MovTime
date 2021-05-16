package com.duckbuddyy.movtime

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovTime : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovTime)
            modules(appModule, dbModule)
        }
    }
}