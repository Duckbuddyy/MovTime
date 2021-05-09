package com.duckbuddyy.movtime.repository

import android.util.Log
import com.duckbuddyy.movtime.model.popular.Popular
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class MovieRepository(private val movieApi: MovieApi) : ApiHandler() {

    suspend fun getPopular(page:Int = 1): Popular = withContext(Dispatchers.IO) {
        try {
            val popular = movieApi.getPopular(page)
            popular
        } catch (e: Exception) {
            Log.d("ApiError", "getPopular encountered an error: $e")
            throw IOException()
        }
    }

}