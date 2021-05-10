package com.duckbuddyy.movtime.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.duckbuddyy.movtime.model.popular.Result
import retrofit2.HttpException
import java.io.IOException

private const val START_PAGE_INDEX = 1

class MoviePagingSource(private val movieRepository: MovieRepository) :
    PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val position = params.key ?: START_PAGE_INDEX

        return try {
            val response = movieRepository.getPopular(page = position)
            val result = response.results
            LoadResult.Page(
                data = result,
                prevKey = if (position == START_PAGE_INDEX) null else position - 1,
                nextKey = if (result.isEmpty()) null else position + 1,
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

}