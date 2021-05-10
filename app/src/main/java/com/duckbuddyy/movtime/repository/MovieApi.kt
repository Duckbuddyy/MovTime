package com.duckbuddyy.movtime.repository

import com.duckbuddyy.movtime.BuildConfig
import com.duckbuddyy.movtime.model.details.Details
import com.duckbuddyy.movtime.model.popular.Popular
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    companion object {
        const val API_KEY = BuildConfig.API_KEY
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val BASE_IMG_URL = "https://image.tmdb.org/t/p/w500/"
    }

    @GET("tv/popular")
    suspend fun getPopular(
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = API_KEY
    ): Popular

    @GET("tv/{tv_id}")
    suspend fun getDetails(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): Details


}