package com.github.ihoyong.mvvmexample.utils

import android.app.Activity

interface ResourceProvider {

    fun getString(rdsId: Int): String

    fun startActivity(activity: Class<*>)
}