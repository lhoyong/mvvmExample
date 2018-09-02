package com.github.ihoyong.mvvmexample.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.github.ihoyong.mvvmexample.databinding.MainItemBinding
import com.github.ihoyong.mvvmexample.domain.model.AgodaItem
import com.github.ihoyong.mvvmexample.ui.viewmodel.MainItemViewModel

class MainViewHolder(private val binding: MainItemBinding) : RecyclerView.ViewHolder(binding.root) {

    private val mainItemViewModel = MainItemViewModel()

    fun bind(agoda: AgodaItem) {
        mainItemViewModel.bind(agoda)

        binding.mainItemViewModel = mainItemViewModel
    }
}