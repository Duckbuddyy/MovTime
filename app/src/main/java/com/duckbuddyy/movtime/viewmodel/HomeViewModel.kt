package com.duckbuddyy.movtime.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.duckbuddyy.movtime.model.popular.Popular
import com.duckbuddyy.movtime.repository.MovieRepository
import com.duckbuddyy.movtime.view.HomeFragmentDirections
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private val _popularShows = MutableLiveData<Popular>()
    val popularShows: LiveData<Popular> = _popularShows

    init {
        getPopular()
    }

    @JvmOverloads
    fun getPopular(page: Int = 1) = viewModelScope.launch(Dispatchers.Main) {
        _popularShows.value = movieRepository.getPopular(page)
    }

    fun goAnotherPage(view: View) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(60735)
        Navigation.findNavController(view).navigate(action)
    }

}