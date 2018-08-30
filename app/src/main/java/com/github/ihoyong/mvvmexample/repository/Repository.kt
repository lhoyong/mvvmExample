package com.github.ihoyong.mvvmexample.repository

import com.github.ihoyong.mvvmexample.model.AgodaItem
import com.github.ihoyong.mvvmexample.model.AgodaRequest
import io.reactivex.Single

interface Repository {

    fun getAgodaList(auth: String, request: AgodaRequest): Single<MutableList<AgodaItem>>
}