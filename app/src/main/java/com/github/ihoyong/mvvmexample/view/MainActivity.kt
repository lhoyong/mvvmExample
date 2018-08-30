package com.github.ihoyong.mvvmexample.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.adapter.MainAdapter
import com.github.ihoyong.mvvmexample.databinding.ActivityMainBinding
import com.github.ihoyong.mvvmexample.network.Api
import com.github.ihoyong.mvvmexample.repository.NetworkRepositoryImpl
import com.github.ihoyong.mvvmexample.viewmodel.MainViewModel
import com.github.ihoyong.mvvmexample.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int = R.layout.activity_main

    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    // TODO factory 의존성 추가
    private fun init() {

        val repository = NetworkRepositoryImpl(Api.create())

        viewModelFactory = MainViewModelFactory(repository)

        val mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        val mAdapter = MainAdapter(this)
        val auth = resources.getString(R.string.auth)

        main_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }

        mainViewModel.getAgodaList(auth, mAdapter)

        viewDataBinding.mainViewModel = mainViewModel

        viewDataBinding.setLifecycleOwner(this)
    }
}
