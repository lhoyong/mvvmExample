package com.github.ihoyong.mvvmexample.ui.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.adapter.MainAdapter
import com.github.ihoyong.mvvmexample.domain.model.*
import com.github.ihoyong.mvvmexample.domain.repository.Repository
import com.github.ihoyong.mvvmexample.utils.ResourceProvider
import com.github.ihoyong.mvvmexample.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers

class MainViewModel(private val repository: Repository, private val resourceProvider: ResourceProvider) : BaseViewModel() {

    val mainAdapter: MainAdapter = MainAdapter()

    private val progressBar = MutableLiveData<Int>()
    private val _error = SingleLiveEvent<Any>()

    val error: LiveData<Any> get() = _error

    fun getProgressBar(): MutableLiveData<Int> = progressBar

    init {

        getAgodaList()
    }

    fun getAgodaList() = addDisposable(repository.getAgodaList(resourceProvider.getString(R.string.auth), getAgodaRequest())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { updateUI(it) }
            .doOnError { errorUI() }
            .subscribe())

    private fun updateUI(item: MutableList<AgodaItem>) {
        mainAdapter.addItems(item)
        mainAdapter.notifyChanged()
        progressBar.value = View.GONE
        _error.value = 0
    }

    private fun errorUI() {
        _error.value = 1
        progressBar.value = View.GONE
    }

    private fun getAgodaRequest(): AgodaRequest {

        val dailyRate = DailyRate(400, 100)

        val occupancy = Occupancy(2)

        val additional = Additional("USD", false, "ko-kr", 20, "PriceAsc", occupancy, dailyRate)

        val criteria = Criteria("2018-10-28", "2018-10-29", 106058, additional)

        return AgodaRequest(criteria)
    }


}