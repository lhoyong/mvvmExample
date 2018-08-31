package com.github.ihoyong.mvvmexample.utils

interface ResourceProvider {

    fun getString(rdsId: Int): String
}