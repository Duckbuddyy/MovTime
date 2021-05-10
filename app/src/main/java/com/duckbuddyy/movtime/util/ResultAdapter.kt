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
import com.duckbuddyy.movtime.model.popular.Result
import com.duckbuddyy.movtime.view.HomeFragmentDirections


class ResultAdapter() :
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
        holder.cardMovieBinding.movie = getItem(position)
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
        val action =
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(result.id)
        Navigation.findNavController(view).navigate(action)
    }

}