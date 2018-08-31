package com.github.ihoyong.mvvmexample.utils

import android.content.Context

class ResourceProviderImpl(private val context: Context) : ResourceProvider {

    override fun getString(rdsId: Int): String {
        return context.resources.getString(rdsId)
    }

}