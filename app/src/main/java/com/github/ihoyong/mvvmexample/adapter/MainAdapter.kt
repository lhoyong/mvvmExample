package com.github.ihoyong.mvvmexample.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.databinding.MainItemBinding
import com.github.ihoyong.mvvmexample.model.AgodaItem
import com.github.ihoyong.mvvmexample.viewholder.MainViewHolder
import kotlinx.android.synthetic.main.main_item.view.*

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mItem: MutableList<AgodaItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       // val binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.main_item, parent, false)

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MainItemBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.main_item, parent, false)
        return MainViewHolder(binding)
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