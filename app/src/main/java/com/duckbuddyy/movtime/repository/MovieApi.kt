package com.duckbuddyy.movtime.repository

import com.duckbuddyy.movtime.BuildConfig
import com.duckbuddyy.movtime.model.popular.Popular
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    companion object {
        const val API_KEY = BuildConfig.API_KEY
        const val BASE_URL = "https://api.themoviedb.org/3/tv/"
    }

    @GET("popular")
    suspend fun getPopular(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY
    ): Popular


}