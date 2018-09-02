package com.github.ihoyong.mvvmexample.domain.model

import com.google.gson.annotations.SerializedName

data class AgodaItem(@SerializedName("hotelId") val id: Int,
                     @SerializedName("hotelName") val name: String,
                     @SerializedName("starRating") val rating: Double,
                     @SerializedName("reviewScore") val score: Double,
                     @SerializedName("reviewCount") val review: Int,
                     @SerializedName("currency") val currency: String,
                     @SerializedName("dailyRate") val dailyRate: Double,
                     @SerializedName("crossedOutRate") val outRate: Double,
                     @SerializedName("discountPercentage") val discountPrecent: Int,
                     @SerializedName("imageURL") val imageUrl: String,
                     @SerializedName("includeBreakfast") val breakfast: Boolean,
                     @SerializedName("freeWifi") val wifi: Boolean,
                     @SerializedName("latitude") val lat: Double,
                     @SerializedName("longitude") val lng: Double)