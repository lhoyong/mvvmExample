package com.github.ihoyong.mvvmexample.domain.model

data class AgodaRequest(val criteria: criteria)

data class criteria(val checkInDate: String,
                    val checkOutDate: String,
                    val cityId: Int,
                    val additional: additional)

data class dailyRate(val maximum: Int, val minimum: Int)

data class occupancy(val numberOfAdult: Int)

data class additional(val currency: String,
                      val discountOnly: Boolean,
                      val language: String,
                      val maxResult: Int,
                      val sortBy: String,
                      val occupancy: occupancy,
                      val dailyRate: dailyRate)

