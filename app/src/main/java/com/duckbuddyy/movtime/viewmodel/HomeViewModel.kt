package com.duckbuddyy.movtime.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.duckbuddyy.movtime.model.popular.Result
import com.duckbuddyy.movtime.repository.MoviePagingSource
import com.duckbuddyy.movtime.view.HomeFragmentDirections
import kotlinx.coroutines.flow.Flow

class HomeViewModel(private val moviePagingSource: MoviePagingSource) : ViewModel() {

    init {
        getListData()
    }

    fun getListData(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(pageSize = 34, maxSize = 200),
            pagingSourceFactory = { moviePagingSource }
        ).flow.cachedIn(viewModelScope)
    }

    fun goDetails(view: View) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(60735)
        Navigation.findNavController(view).navigate(action)
    }

}