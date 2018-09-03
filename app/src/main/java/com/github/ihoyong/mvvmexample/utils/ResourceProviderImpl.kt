package com.github.ihoyong.mvvmexample.utils

import android.app.Activity
import android.content.Context
import android.content.Intent

class ResourceProviderImpl(private val context: Context) : ResourceProvider {

    override fun getString(rdsId: Int): String {
        return context.resources.getString(rdsId)
    }

    override fun startActivity(activity: Class<*>) {
        context.startActivity(Intent(context, activity))
    }
}