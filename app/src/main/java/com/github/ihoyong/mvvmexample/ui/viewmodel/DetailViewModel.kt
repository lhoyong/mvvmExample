package com.github.ihoyong.mvvmexample.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.domain.model.*
import com.github.ihoyong.mvvmexample.domain.repository.DetailRepository
import com.github.ihoyong.mvvmexample.utils.ResourceProvider
import io.reactivex.android.schedulers.AndroidSchedulers

class DetailViewModel(private val repository: DetailRepository, private val resourceProvider: ResourceProvider) : BaseViewModel() {

    private val imageUrl = MutableLiveData<String>()
    private val title = MutableLiveData<String>()
    private val dailyRate = MutableLiveData<String>()

    init {
        getHotelData()
    }

    fun getImageUrl(): MutableLiveData<String> {
        return imageUrl
    }

    fun getTitle(): MutableLiveData<String> {
        return title
    }

    fun getDailyRate(): MutableLiveData<String> {
        return dailyRate
    }

    private fun getHotelData() = addDisposable(repository.getHotel(resourceProvider.getString(R.string.auth), getAgodaRequest())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it -> it[0] }
            .doOnSuccess { updateUI(it) }
            .doOnError { it.printStackTrace() }
            .subscribe()
    )

    private fun updateUI(item: AgodaItem) {
        imageUrl.value = item.imageUrl
        title.value = item.name
        dailyRate.value = item.dailyRate.toString()
    }

    private fun getAgodaRequest(): HotelRequest {

        val occupancy = Occupancy(2)
        val additional = DetailAdditional("KRW", false, "ko-kr", occupancy)

        val criteria = DetailCriteria("2018-10-28", "2018-10-29", intArrayOf(266523), additional)

        return HotelRequest(criteria)
    }
}