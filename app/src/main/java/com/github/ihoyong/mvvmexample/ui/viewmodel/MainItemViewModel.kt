package com.github.ihoyong.mvvmexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.github.ihoyong.mvvmexample.domain.model.AgodaItem
import com.github.ihoyong.mvvmexample.utils.SingleLiveEvent
import com.github.ihoyong.mvvmexample.utils.StringUtils

class MainItemViewModel : BaseViewModel() {

    private val name = MutableLiveData<String>()
    private val score = MutableLiveData<String>()
    private val dailyRate = MutableLiveData<String>()
    private val discount = MutableLiveData<String>()
    private val wifi = MutableLiveData<String>()
    private val breakFast = MutableLiveData<String>()
    private val imageUrl = MutableLiveData<String>()
    private val clickEvent = SingleLiveEvent<Any>()

    fun bind(agoda: AgodaItem) {
        name.value = agoda.name
        score.value = "평점- " + agoda.score.toString()
        dailyRate.value = agoda.dailyRate.toString() + " 달러"
        discount.value = agoda.discountPrecent.toString() + " %"
        wifi.value = StringUtils.convertWifi(agoda.wifi)
        breakFast.value = StringUtils.convertBreakFast(agoda.breakfast)
        imageUrl.value = agoda.imageUrl

    }

    fun getName(): MutableLiveData<String> {
        return name
    }

    fun getScore(): MutableLiveData<String> {
        return score
    }

    fun getDailyRate(): MutableLiveData<String> {
        return dailyRate
    }

    fun getDiscount(): MutableLiveData<String> {
        return discount
    }

    fun getWifi(): MutableLiveData<String> {
        return wifi
    }

    fun getBreakFast(): MutableLiveData<String> {
        return breakFast
    }

    fun getImageUrl(): MutableLiveData<String> {
        return imageUrl
    }

    fun showDetail() {
        clickEvent.call()
    }


}