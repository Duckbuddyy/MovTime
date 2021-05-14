package com.duckbuddyy.movtime.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.duckbuddyy.movtime.R
import com.duckbuddyy.movtime.databinding.ItemResultBinding
import com.duckbuddyy.movtime.model.favourite.Favourite
import com.duckbuddyy.movtime.model.favourite.FavouriteDao
import com.duckbuddyy.movtime.model.popular.Result
import com.duckbuddyy.movtime.view.HomeFragmentDirections


class ResultAdapter(private val favouriteDao: FavouriteDao) :
    PagingDataAdapter<Result, ResultAdapter.ResultViewHolder>(MOVIE_COMPARATOR),
    ResultItemClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemResultBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_result,
            parent,
            false
        )

        return ResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val result = getItem(position)!!
        if (favouriteDao.isFavourite(result.id) == null) {
            val favourite = Favourite(result.id, false)
            favouriteDao.insert(favourite)
        }
        holder.cardMovieBinding.isFavourite = favouriteDao.isFavourite(result.id)
        holder.cardMovieBinding.movie = result
        holder.cardMovieBinding.resultItemClick = this
    }

    inner class ResultViewHolder(val cardMovieBinding: ItemResultBinding) :
        RecyclerView.ViewHolder(cardMovieBinding.root)

    companion object {
        private val MOVIE_COMPARATOR = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Result, newItem: Result) =
                oldItem == newItem

        }
    }

    override fun onResultItemClicked(view: View, result: Result) {
        when (view.id) {
            R.id.fav_button -> {
                val currentFav = favouriteDao.isFavourite(result.id)!!
                favouriteDao.updateFavourite(result.id, !currentFav)
            }
            R.id.card_view -> {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(result.id)
                Navigation.findNavController(view).navigate(action)
            }
        }
    }

}