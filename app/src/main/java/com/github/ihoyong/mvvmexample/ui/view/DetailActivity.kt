package com.github.ihoyong.mvvmexample.ui.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.databinding.ActivityDetailBinding
import com.github.ihoyong.mvvmexample.domain.repository.DetailRepositoryImpl
import com.github.ihoyong.mvvmexample.network.Api
import com.github.ihoyong.mvvmexample.utils.ResourceProviderImpl
import com.github.ihoyong.mvvmexample.ui.viewmodel.DetailViewModel
import com.github.ihoyong.mvvmexample.ui.viewmodel.DetailViewModelFactory

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    private lateinit var viewModelFactory: DetailViewModelFactory

    private val resourceProvider by lazy { ResourceProviderImpl(applicationContext) }

    private val repository by lazy { DetailRepositoryImpl(Api.create()) }

    override val layoutResourceId: Int = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelFactory = DetailViewModelFactory(repository, resourceProvider)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)

        viewDataBinding.viewModel = viewModel
        viewDataBinding.setLifecycleOwner(this)
    }
}