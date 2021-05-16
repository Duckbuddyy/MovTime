package com.duckbuddyy.movtime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duckbuddyy.movtime.model.details.Details
import com.duckbuddyy.movtime.model.favourite.FavouriteDao
import com.duckbuddyy.movtime.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(
    private val movieRepository: MovieRepository,
    private val favouriteDao: FavouriteDao,
    private val tvId: Int
) : ViewModel() {
    private val _showDetails = MutableLiveData<Details>()
    val showDetails: LiveData<Details> = _showDetails

    val isFavourite: MutableLiveData<Boolean> = MutableLiveData(favouriteDao.isFavourite(tvId))

    init {
        getDetails()
    }

    private fun getDetails() = viewModelScope.launch(Dispatchers.Main) {
        _showDetails.value = movieRepository.getDetails(tvId)
    }

    fun favourite() {
        favouriteDao.updateFavourite(tvId, !(isFavourite.value!!))
        isFavourite.value = favouriteDao.isFavourite(tvId)
    }
}