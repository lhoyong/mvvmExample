package com.github.ihoyong.mvvmexample.utils

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.ihoyong.mvvmexample.ui.view.DetailActivity
import com.github.ihoyong.mvvmexample.utils.extension.getParentActivity

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String?) {

    Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()

    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { view.text = it ?: "" })
    }
}

@BindingAdapter("mainItemClick")
fun setMainItemClick(view: View, hotelId: LiveData<Int>) {

    view.setOnClickListener {
        view.context.startActivity(Intent(view.context, DetailActivity::class.java).apply {
            putExtra("hotelId", hotelId.value)
        })
    }
}


@BindingAdapter("visible")
fun setProgressBar(view: View, visibility: MutableLiveData<Int>?) {
    val parent: AppCompatActivity? = view.getParentActivity()

    if (parent != null && visibility != null) {
        visibility.observe(parent, Observer { view.visibility = it ?: View.VISIBLE })
    }
}