package com.github.ihoyong.mvvmexample.viewmodel

import android.util.Log
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.adapter.MainAdapter
import com.github.ihoyong.mvvmexample.model.*
import com.github.ihoyong.mvvmexample.repository.Repository
import com.github.ihoyong.mvvmexample.utils.ResourceProvider
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


        val dailyRate = dailyRate(400, 100)

        val occupancy = occupancy(2)

        val additional = additional("USD", false, "ko-kr", 20, "PriceAsc", occupancy, dailyRate)

        val criteria = criteria("2018-10-28", "2018-10-29", 106058, additional)

        return AgodaRequest(criteria)


    }


}