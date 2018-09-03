package com.github.ihoyong.mvvmexample.domain.repository

import com.github.ihoyong.mvvmexample.domain.model.AgodaItem
import com.github.ihoyong.mvvmexample.domain.model.AgodaRequest
import io.reactivex.Single

interface Repository {

    fun getAgodaList(auth: String, request: AgodaRequest): Single<MutableList<AgodaItem>>
}