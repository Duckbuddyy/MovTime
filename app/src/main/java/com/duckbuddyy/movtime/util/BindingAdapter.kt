package com.duckbuddyy.movtime.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.duckbuddyy.movtime.R
import com.duckbuddyy.movtime.model.details.Genre
import com.duckbuddyy.movtime.repository.MovieApi


@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.apply {
        layoutManager = GridLayoutManager(context, 2)
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

@BindingAdapter("imageSrc")
fun ImageView.loadImage(url: String?) {
    if (url != null) {
        Glide.with(this)
            .load("${MovieApi.BASE_IMG_URL}$url")
            .error(R.drawable.ic_not_found)
            .centerCrop()
            .into(this)
    } else {
        //TODO add loading
    }
}

@BindingAdapter("arraySrc")
fun TextView.loadText(array: List<Genre>?) {
    if(array!= null) {
        val builder = StringBuilder()
        for (element in array) {
            builder.append(element.name)
            builder.append("\n")
        }
        builder.trim()
        this.text = builder.toString()
    }
    else{
        //Todo add loading
    }
}