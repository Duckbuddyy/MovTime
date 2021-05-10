package com.duckbuddyy.movtime.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.duckbuddyy.movtime.repository.MovieApi


@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

@BindingAdapter(value = ["imageUrl"])
fun loadImage(view: ImageView, url: String) {
    Glide.with(view).load("${MovieApi.BASE_IMG_URL}$url").into(view)
}

//TODO loadImage'e error eklenecek
//@BindingAdapter("imageUrl", "error")
//fun loadImage(view: ImageView, url: String, error: Drawable) {
//    Picasso.get().load(url).error(error).into(view)
//}