package com.github.ihoyong.mvvmexample.domain.repository

import com.github.ihoyong.mvvmexample.domain.model.AgodaItem
import com.github.ihoyong.mvvmexample.domain.model.AgodaRequest
import com.github.ihoyong.mvvmexample.domain.model.HotelRequest
import io.reactivex.Single

interface DetailRepository {

    fun getHotel(auth: String, request: HotelRequest): Single<MutableList<AgodaItem>>
}