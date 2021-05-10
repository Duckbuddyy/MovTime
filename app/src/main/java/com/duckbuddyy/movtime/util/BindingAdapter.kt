package com.duckbuddyy.movtime.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.duckbuddyy.movtime.R
import com.duckbuddyy.movtime.repository.MovieApi


@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

@BindingAdapter("imageSrc")
fun ImageView.loadImage(url: String?) {
    if (url != null) {
        Glide.with(this)
            .load("${MovieApi.BASE_IMG_URL}$url")
            .error(R.drawable.image_not_found)
            .into(this)
    }
    else{
        //TODO Glide Loading
    }
}