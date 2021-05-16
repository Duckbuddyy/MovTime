package com.duckbuddyy.movtime.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.duckbuddyy.movtime.model.favourite.FavouriteDao
import com.duckbuddyy.movtime.model.popular.Result
import com.duckbuddyy.movtime.view.HomeFragmentDirections

class ItemViewModel(val result: Result, private val favouriteDao: FavouriteDao) : ViewModel() {
    val isFavourite: MutableLiveData<Boolean> = MutableLiveData(favouriteDao.isFavourite(result.id))

    fun favourite() {
        favouriteDao.updateFavourite(result.id, !(isFavourite.value!!))
        isFavourite.value = favouriteDao.isFavourite(result.id)
    }

    fun goDetails(view: View) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(result.id)
        Navigation.findNavController(view).navigate(action)
    }

}