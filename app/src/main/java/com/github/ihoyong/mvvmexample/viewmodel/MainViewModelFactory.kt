package com.github.ihoyong.mvvmexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.ihoyong.mvvmexample.repository.Repository
import com.github.ihoyong.mvvmexample.utils.ResourceProvider

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val repository: Repository, private val resoureceProvider: ResourceProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository, resoureceProvider) as T
    }
}