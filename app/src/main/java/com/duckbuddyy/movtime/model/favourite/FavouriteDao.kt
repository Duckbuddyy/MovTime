package com.duckbuddyy.movtime.model.favourite

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouriteDao {
    @Query("SELECT * FROM Favourite")
    fun getAll(): List<Favourite>

    @Query("SELECT fav FROM Favourite WHERE id = :id ")
    fun isFavourite(id: Int): Boolean?

    @Query("UPDATE Favourite SET fav = :fav WHERE id = :id")
    fun updateFavourite(id: Int,fav: Boolean)

    @Insert
    fun insert(vararg favourite: Favourite)

}