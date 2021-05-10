package com.duckbuddyy.movtime.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.duckbuddyy.movtime.R
import com.duckbuddyy.movtime.databinding.ItemResultBinding
import com.duckbuddyy.movtime.model.popular.Result

class ResultAdapter(private val movies: List<Result>) :
    RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    inner class ResultViewHolder(val cardMovieBinding: ItemResultBinding) :
        RecyclerView.ViewHolder(cardMovieBinding.root)

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
        holder.cardMovieBinding.movie = movies[position]
    }

    override fun getItemCount(): Int = movies.size

}