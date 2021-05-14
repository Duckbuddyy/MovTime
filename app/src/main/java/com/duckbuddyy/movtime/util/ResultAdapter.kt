package com.duckbuddyy.movtime.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.duckbuddyy.movtime.R
import com.duckbuddyy.movtime.databinding.ItemResultBinding
import com.duckbuddyy.movtime.model.favourite.FavouriteDao
import com.duckbuddyy.movtime.model.popular.Result
import com.duckbuddyy.movtime.viewmodel.ItemViewModel

class ResultAdapter(
    private val favouriteDao: FavouriteDao
) : PagingDataAdapter<Result, ResultAdapter.ResultViewHolder>(MOVIE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemResultBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_result,
            parent,
            false
        )
        binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        return ResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val result = getItem(position)!!
        holder.binding.viewmodel = ItemViewModel(result, favouriteDao)
    }

    inner class ResultViewHolder(val binding: ItemResultBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val MOVIE_COMPARATOR = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Result, newItem: Result) =
                oldItem == newItem

        }
    }

}