package com.github.ihoyong.mvvmexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.databinding.MainItemBinding
import com.github.ihoyong.mvvmexample.domain.model.AgodaItem
import com.github.ihoyong.mvvmexample.ui.viewmodel.MainItemViewModel

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mItem: MutableList<AgodaItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

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

class MainViewHolder(private val binding: MainItemBinding) : RecyclerView.ViewHolder(binding.root) {

    private val mainItemViewModel = MainItemViewModel()

    fun bind(agoda: AgodaItem) {
        mainItemViewModel.bind(agoda)

        binding.mainItemViewModel = mainItemViewModel
    }
}