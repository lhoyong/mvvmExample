package com.github.ihoyong.mvvmexample.ui.viewmodel

import android.util.Log
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.adapter.MainAdapter
import com.github.ihoyong.mvvmexample.domain.model.*
import com.github.ihoyong.mvvmexample.domain.repository.Repository
import com.github.ihoyong.mvvmexample.ui.view.DetailActivity
import com.github.ihoyong.mvvmexample.utils.ResourceProvider
import com.github.ihoyong.mvvmexample.utils.SingleLiveEvent
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

class MainViewModel(private val repository: Repository, private val resourceProvider: ResourceProvider) : BaseViewModel() {

    val mainAdapter: MainAdapter = MainAdapter()

    init {

        getAgodaList()
    }

    fun getAgodaList() {

        addDisposable(repository.getAgodaList(resourceProvider.getString(R.string.auth), getAgodaRequest())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mainAdapter.addItems(it)
                    mainAdapter.notifyChanged()
                }, {})

        )
    }

    // TODO 제거
    private fun getAgodaRequest(): AgodaRequest {

        val dailyRate = DailyRate(400, 100)

        val occupancy = Occupancy(2)

        val additional = Additional("USD", false, "ko-kr", 20, "PriceAsc", occupancy, dailyRate)

        val criteria = Criteria("2018-10-28", "2018-10-29", 106058, additional)

        return AgodaRequest(criteria)
    }


}