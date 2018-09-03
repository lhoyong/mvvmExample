package com.github.ihoyong.mvvmexample.domain.model

import com.google.gson.annotations.SerializedName

data class AgodaRequest(@SerializedName("criteria") val criteria: Criteria)
data class HotelRequest(@SerializedName("criteria") val criteria: DetailCriteria)

data class Criteria(val checkInDate: String,
                    val checkOutDate: String,
                    val cityId: Int,
                    @SerializedName("additional") val additional: Additional)

data class DailyRate(val maximum: Int, val minimum: Int)

data class Occupancy(val numberOfAdult: Int)

data class Additional(val currency: String,
                      val discountOnly: Boolean,
                      val language: String,
                      val maxResult: Int,
                      val sortBy: String,
                      @SerializedName("occupancy") val occupancy: Occupancy,
                      @SerializedName("dailyRate") val dailyRate: DailyRate)

data class DetailCriteria(val checkInDate: String,
                          val checkOutDate: String,
                          val hotelId: IntArray,
                          @SerializedName("additional") val additional: DetailAdditional)

data class DetailAdditional(val currency: String,
                            val discountOnly: Boolean,
                            val language: String,
                            @SerializedName("occupancy") val occupancy: Occupancy)
