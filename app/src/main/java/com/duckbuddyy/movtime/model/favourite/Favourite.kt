package com.duckbuddyy.movtime.model.favourite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favourite(@PrimaryKey val id:Int, @ColumnInfo(name="fav") val fav: Boolean )
