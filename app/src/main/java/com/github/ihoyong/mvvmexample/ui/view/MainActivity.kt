package com.github.ihoyong.mvvmexample.ui.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.databinding.ActivityMainBinding
import com.github.ihoyong.mvvmexample.network.Api
import com.github.ihoyong.mvvmexample.domain.repository.NetworkRepositoryImpl
import com.github.ihoyong.mvvmexample.utils.ResourceProviderImpl
import com.github.ihoyong.mvvmexample.ui.viewmodel.MainViewModel
import com.github.ihoyong.mvvmexample.ui.viewmodel.MainViewModelFactory

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var viewModelFactory: MainViewModelFactory

    private val repository by lazy { NetworkRepositoryImpl(Api.create()) }

    override val layoutResourceId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModelFactory = MainViewModelFactory(repository, ResourceProviderImpl(this))

        val mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        viewDataBinding.mainViewModel = mainViewModel
        viewDataBinding.setLifecycleOwner(this)
    }


}
