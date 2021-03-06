package com.github.ihoyong.mvvmexample.ui.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.ihoyong.mvvmexample.R
import com.github.ihoyong.mvvmexample.domain.model.*
import com.github.ihoyong.mvvmexample.domain.repository.DetailRepository
import com.github.ihoyong.mvvmexample.utils.ResourceProvider
import com.github.ihoyong.mvvmexample.utils.SingleLiveEvent
import com.github.ihoyong.mvvmexample.utils.StringUtils
import io.reactivex.android.schedulers.AndroidSchedulers

class DetailViewModel(private val repository: DetailRepository,
                      private val resourceProvider: ResourceProvider,
                      private val hotelId: Int?)
    : BaseViewModel() {

    private val imageUrl = MutableLiveData<String>()
    private val title = MutableLiveData<String>()
    private val dailyRate = MutableLiveData<String>()
    private val disCount = MutableLiveData<String>()
    private val progressBar = MutableLiveData<Int>()
    private val breakFast = MutableLiveData<String>()
    private val wifi = MutableLiveData<String>()

    private val titleLayer = MutableLiveData<Int>()
    private val breakFastLayer = MutableLiveData<Int>()
    private val wifiLayer = MutableLiveData<Int>()

    private val _error = SingleLiveEvent<Int>()

    val error: LiveData<Int> get() = _error

    init {
        getHotelData()
    }

    fun getImageUrl(): MutableLiveData<String> = imageUrl

    fun getTitle(): MutableLiveData<String> = title

    fun getDailyRate(): MutableLiveData<String> = dailyRate

    fun getDisCount(): MutableLiveData<String> = disCount

    fun getProgressBar(): MutableLiveData<Int> = progressBar

    fun getBreakFast(): MutableLiveData<String> = breakFast

    fun getWifi(): MutableLiveData<String> = wifi

    // if progress gone visible text
    fun getTitleLayer(): MutableLiveData<Int> = titleLayer

    fun getBreakFastLayer(): MutableLiveData<Int> = breakFastLayer
    fun getWifiLayer(): MutableLiveData<Int> = wifiLayer

    private fun getHotelData() = addDisposable(repository.getHotel(resourceProvider.getString(R.string.auth), getAgodaRequest())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it -> it[0] }
            .doOnSuccess { updateUI(it) }
            .doOnError { errorUI() }
            .subscribe()
    )

    private fun updateUI(item: AgodaItem) {
        imageUrl.value = item.imageUrl
        title.value = item.name
        dailyRate.value = StringUtils.convertDailyRate(item.dailyRate)
        disCount.value = StringUtils.convertDiscount(item.discountPrecent)
        breakFast.value = StringUtils.convertBreakFast(item.breakfast)
        wifi.value = StringUtils.convertWifi(item.wifi)
        progressBar.value = View.GONE
        titleLayer.value = View.VISIBLE
        breakFastLayer.value = View.VISIBLE
        wifiLayer.value = View.VISIBLE
    }

    private fun errorUI() {
        _error.value = 0
        progressBar.value = View.GONE
    }

    private fun getAgodaRequest(): HotelRequest {

        val occupancy = Occupancy(2)
        val additional = DetailAdditional("KRW", false, "ko-kr", occupancy)

        val criteria = DetailCriteria("2018-10-28", "2018-10-29", intArrayOf(hotelId!!), additional)

        return HotelRequest(criteria)
    }
}