package com.duckbuddyy.movtime.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.duckbuddyy.movtime.model.favourite.Favourite
import com.duckbuddyy.movtime.model.favourite.FavouriteDao

@Database(entities = [Favourite::class],version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getDao(): FavouriteDao
}