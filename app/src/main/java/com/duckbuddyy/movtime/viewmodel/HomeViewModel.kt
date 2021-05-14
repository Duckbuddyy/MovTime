package com.duckbuddyy.movtime.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.duckbuddyy.movtime.model.popular.Result
import com.duckbuddyy.movtime.repository.MoviePagingSource
import com.duckbuddyy.movtime.util.ResultAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeViewModel(
    private val moviePagingSource: MoviePagingSource,
    val adapter: ResultAdapter
) : ViewModel() {

    init {
        GlobalScope.launch(Dispatchers.Main) {
            getListData().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun getListData(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(pageSize = 20, maxSize = 200),
            pagingSourceFactory = { moviePagingSource }
        ).flow.cachedIn(viewModelScope)
    }
}