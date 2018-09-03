package com.github.ihoyong.mvvmexample.utils

object StringUtils {

    fun convertWifi(wifi: Boolean): String {
        return if (wifi) {
            "와이파이 : 제공"
        } else {
            "와이파이 : 미제공"
        }
    }

    fun convertBreakFast(bf: Boolean): String {
        return if (bf) {
            "아침 : 제공"
        } else {
            "아침 : 미제공"
        }
    }
}
