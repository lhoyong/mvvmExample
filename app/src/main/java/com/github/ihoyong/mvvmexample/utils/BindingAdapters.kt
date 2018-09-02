package com.github.ihoyong.mvvmexample.utils

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.ihoyong.mvvmexample.ui.view.DetailActivity
import org.jetbrains.annotations.NotNull

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

// TODO adapter? 에서 클릭이벤트 이렇게 하면안되는대 하는방법을 모르겟..
@BindingAdapter("android:onClick")
fun setOnClickListener(view: View, runnable: Runnable) {
    view.setOnClickListener {
        view.context.startActivity(Intent(view.context, DetailActivity::class.java))
        runnable.run()
    }
}