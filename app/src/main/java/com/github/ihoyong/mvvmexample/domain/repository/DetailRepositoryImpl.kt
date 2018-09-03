package com.github.ihoyong.mvvmexample.domain.repository

import com.github.ihoyong.mvvmexample.domain.model.AgodaItem
import com.github.ihoyong.mvvmexample.domain.model.AgodaRequest
import com.github.ihoyong.mvvmexample.domain.model.HotelRequest
import com.github.ihoyong.mvvmexample.network.Api
import io.reactivex.Single

class DetailRepositoryImpl(private val api: Api) : DetailRepository {

    override fun getHotel(auth: String, request: HotelRequest): Single<MutableList<AgodaItem>> =
            api.hotel(auth, request)
                    .map { it -> it.agoda }
}