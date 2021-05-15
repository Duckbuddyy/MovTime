package com.duckbuddyy.movtime

import android.app.Application
import com.duckbuddyy.movtime.model.favourite.FavouriteDao
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovTime:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MovTime)
            modules(appModule, dbModule)
        }
    }
}