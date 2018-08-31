package com.github.ihoyong.mvvmexample.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.ihoyong.mvvmexample.model.AgodaItem

class MainItemViewModel : BaseViewModel() {

    private val name = MutableLiveData<String>()
    private val score = MutableLiveData<String>()
    private val dailyRate = MutableLiveData<String>()
    private val discount = MutableLiveData<String>()
    private val wifi = MutableLiveData<String>()
    private val breakFast = MutableLiveData<String>()
    private val imageUrl = MutableLiveData<String>()

    fun bind(agoda: AgodaItem) {
        name.value = agoda.name
        score.value = "평점- " + agoda.score.toString()
        dailyRate.value = agoda.dailyRate.toString() + " 달러"
        discount.value = agoda.discountPrecent.toString() + " %"
        wifi.value = convertWifi(agoda.wifi)
        breakFast.value = convertBreakFast(agoda.breakfast)
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

    fun convertWifi(wifi: Boolean): String {
        if (wifi) {
            return "와이파이 : 제공"
        } else {
            return "와이파이 : 미제공"
        }
    }

    fun convertBreakFast(bf: Boolean): String {
        if (bf) {
            return "아침 : 제공"
        } else {
            return "아침 : 미제공"
        }
    }
}