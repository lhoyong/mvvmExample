package com.github.ihoyong.mvvmexample.viewmodel

import com.github.ihoyong.mvvmexample.adapter.MainAdapter
import com.github.ihoyong.mvvmexample.model.*
import com.github.ihoyong.mvvmexample.network.Api
import com.github.ihoyong.mvvmexample.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import org.json.JSONObject

class MainViewModel(private val repository: Repository) : BaseViewModel() {

    fun getAgodaList(auth: String, adapter: MainAdapter) {

        addDisposable(repository.getAgodaList(auth, getAgodaRequest())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapter.addItems(it)
                    adapter.notifyChanged()
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