package com.github.ihoyong.mvvmexample.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.ihoyong.mvvmexample.utils.ResourceProvider

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(private val resourceProvider: ResourceProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(resourceProvider) as T
    }
}