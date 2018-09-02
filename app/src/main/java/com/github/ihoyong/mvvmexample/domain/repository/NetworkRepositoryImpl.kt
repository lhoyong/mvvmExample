package com.github.ihoyong.mvvmexample.domain.repository

import com.github.ihoyong.mvvmexample.domain.model.AgodaItem
import com.github.ihoyong.mvvmexample.domain.model.AgodaRequest
import com.github.ihoyong.mvvmexample.network.Api
import io.reactivex.Single

class NetworkRepositoryImpl(private val api: Api) : Repository {

    override fun getAgodaList(auth: String, request: AgodaRequest): Single<MutableList<AgodaItem>> =
            api.agoda(auth, request)
                    .map { it -> it.agoda }
}