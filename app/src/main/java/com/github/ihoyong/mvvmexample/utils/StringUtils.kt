package com.github.ihoyong.mvvmexample.utils

object StringUtils {

    fun convertWifi(wifi: Boolean): String = if (wifi) {
        "제공"
    } else {
        "미제공"
    }

    fun convertBreakFast(bf: Boolean): String = if (bf) {
        "제공"
    } else {
        "미제공"
    }

    fun convertDailyRate(rate: Double): String {
        return "${rate}원"
    }

    fun convertDiscount(percent: Int): String {
        return "$percent%"
    }
}
