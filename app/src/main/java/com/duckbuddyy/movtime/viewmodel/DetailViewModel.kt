package com.duckbuddyy.movtime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duckbuddyy.movtime.model.details.Details
import com.duckbuddyy.movtime.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val movieRepository: MovieRepository, private val tvId: Int) :
    ViewModel() {
    private val _showDetails = MutableLiveData<Details>()
    val showDetails: LiveData<Details> = _showDetails

    init {
        getDetails()
    }

    @JvmOverloads
    fun getDetails(page: Int = 1) = viewModelScope.launch(Dispatchers.Main) {
        _showDetails.value = movieRepository.getDetails(tvId)
        println(showDetails)
    }
}