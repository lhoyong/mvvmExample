package com.github.ihoyong.mvvmexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.model.AgodaItem
import com.github.ihoyong.mvvmexample.viewholder.MainViewHolder

class MainAdapter(private val context: Context) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mItem: MutableList<AgodaItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_item, parent, false), context)
    }

    override fun getItemCount(): Int = mItem.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainViewHolder).bind(mItem[position])
    }

    fun addItems(items: MutableList<AgodaItem>) {
        mItem.addAll(items)
    }

    fun notifyChanged() {
        notifyDataSetChanged()
    }
}