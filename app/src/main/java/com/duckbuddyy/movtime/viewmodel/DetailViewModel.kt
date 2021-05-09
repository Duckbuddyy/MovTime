package com.duckbuddyy.movtime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duckbuddyy.movtime.model.popular.Popular
import com.duckbuddyy.movtime.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private val _popularShows = MutableLiveData<Popular>()
    val popularShows: LiveData<Popular> = _popularShows

    init {
        getPopular()
    }

    @JvmOverloads
    fun getPopular(page: Int = 1) = viewModelScope.launch(Dispatchers.Main) {
        _popularShows.value = movieRepository.getPopular(page)
    }
}