package com.github.ihoyong.mvvmexample.repository

import com.github.ihoyong.mvvmexample.model.AgodaItem
import com.github.ihoyong.mvvmexample.model.AgodaRequest
import com.github.ihoyong.mvvmexample.network.Api
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

class NetworkRepositoryImpl(private val api: Api) : Repository {

    override fun getAgodaList(auth: String, request: AgodaRequest): Single<MutableList<AgodaItem>> =
            api.agoda(auth, request)
                    .map { it -> it.agoda }
}