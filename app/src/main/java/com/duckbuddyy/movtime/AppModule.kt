package com.duckbuddyy.movtime

import androidx.lifecycle.LifecycleOwner
import androidx.room.Room
import com.duckbuddyy.movtime.repository.AppDatabase
import com.duckbuddyy.movtime.repository.MovieApi
import com.duckbuddyy.movtime.repository.MoviePagingSource
import com.duckbuddyy.movtime.repository.MovieRepository
import com.duckbuddyy.movtime.util.ResultAdapter
import com.duckbuddyy.movtime.viewmodel.DetailViewModel
import com.duckbuddyy.movtime.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@JvmField
val appModule = module {
    single<MovieApi> {
        Retrofit.Builder().baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MovieApi::class.java)
    }

    single { MovieRepository(get()) }

    single { MoviePagingSource(get()) }

    single { ResultAdapter(get()) }

    viewModel { HomeViewModel(get(), get()) }

    viewModel { DetailViewModel(get(), get()) }

}

val dbModule = module {

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "AppDatabase.db")
            .allowMainThreadQueries()
            .build()
    }

    single { get<AppDatabase>().getDao() }
}