package com.github.ihoyong.mvvmexample.ui.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.github.ihoyong.mvvmexample.domain.model.AgodaItem
import com.github.ihoyong.mvvmexample.utils.SingleLiveEvent
import com.github.ihoyong.mvvmexample.utils.StringUtils
import io.reactivex.Single

class MainItemViewModel : BaseViewModel() {

    private val name = MutableLiveData<String>()
    private val score = MutableLiveData<String>()
    private val dailyRate = MutableLiveData<String>()
    private val discount = MutableLiveData<String>()
    private val wifi = MutableLiveData<String>()
    private val breakFast = MutableLiveData<String>()
    private val imageUrl = MutableLiveData<String>()
    private val _clickEvent = SingleLiveEvent<Int>()

    val clickEvent: LiveData<Int> get() = _clickEvent

    fun bind(agoda: AgodaItem) {
        name.value = agoda.name
        score.value = "평점- " + agoda.score.toString()
        dailyRate.value = agoda.dailyRate.toString() + " 달러"
        discount.value = agoda.discountPrecent.toString() + " %"
        wifi.value = StringUtils.convertWifi(agoda.wifi)
        breakFast.value = StringUtils.convertBreakFast(agoda.breakfast)
        imageUrl.value = agoda.imageUrl

        _clickEvent.value = agoda.id
    }

    fun getName(): MutableLiveData<String> = name

    fun getScore(): MutableLiveData<String> = score

    fun getDailyRate(): MutableLiveData<String> = dailyRate

    fun getDiscount(): MutableLiveData<String> = discount

    fun getWifi(): MutableLiveData<String> = wifi

    fun getBreakFast(): MutableLiveData<String> = breakFast

    fun getImageUrl(): MutableLiveData<String> = imageUrl

}
