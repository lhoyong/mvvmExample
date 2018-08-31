package com.github.ihoyong.mvvmexample.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
}