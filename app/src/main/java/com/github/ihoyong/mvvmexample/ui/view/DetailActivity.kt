package com.github.ihoyong.mvvmexample.ui.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.databinding.ActivityDetailBinding
import com.github.ihoyong.mvvmexample.domain.repository.DetailRepositoryImpl
import com.github.ihoyong.mvvmexample.network.Api
import com.github.ihoyong.mvvmexample.utils.ResourceProviderImpl
import com.github.ihoyong.mvvmexample.ui.viewmodel.DetailViewModel
import com.github.ihoyong.mvvmexample.ui.viewmodel.DetailViewModelFactory
import com.github.ihoyong.mvvmexample.utils.extension.viewModelProvider

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    private lateinit var viewModelFactory: DetailViewModelFactory

    private val resourceProvider by lazy { ResourceProviderImpl(applicationContext) }

    private val repository by lazy { DetailRepositoryImpl(Api.create()) }

    private val getHotelId: Int? get() = intent.getIntExtra("hotelId", 0)

    override val layoutResourceId: Int = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelFactory = DetailViewModelFactory(repository, resourceProvider, getHotelId)

        val detailViewModel: DetailViewModel = viewModelProvider(viewModelFactory)

        detailViewModel.error.observe(this, Observer { value ->
            if (value == 0) Toast.makeText(this, "정보를 불러올 수 없습니다. 다시 시도하세요.", Toast.LENGTH_SHORT).show()
        })
        viewDataBinding.viewModel = detailViewModel
        viewDataBinding.setLifecycleOwner(this)
    }
}