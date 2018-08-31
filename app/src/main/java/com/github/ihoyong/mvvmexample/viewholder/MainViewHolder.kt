package com.github.ihoyong.mvvmexample.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.github.ihoyong.mvvmexample.databinding.MainItemBinding
import com.github.ihoyong.mvvmexample.model.AgodaItem
import com.github.ihoyong.mvvmexample.viewmodel.MainItemViewModel

class MainViewHolder(private val binding: MainItemBinding) : RecyclerView.ViewHolder(binding.root) {

    private val mainItemViewModel = MainItemViewModel()

    fun bind(agoda: AgodaItem) {
        mainItemViewModel.bind(agoda)
        binding.mainItemViewModel = mainItemViewModel
    }
}