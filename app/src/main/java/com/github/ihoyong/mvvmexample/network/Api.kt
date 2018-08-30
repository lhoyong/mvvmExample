package com.github.ihoyong.mvvmexample.network

import com.github.ihoyong.mvvmexample.model.AgodaItem
import com.github.ihoyong.mvvmexample.model.AgodaRequest
import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {

    @Headers("Content-Type: application/json")
    @POST("affiliateservice/lt_v1")
    fun agoda(@Header("Authorization") header: String,
              @Body request: AgodaRequest): Single<AgodaResult>

    data class AgodaResult(@SerializedName("results") val agoda: MutableList<AgodaItem>)

    companion object {

        const val BASE_URL = "https://affiliateapi7643.agoda.com/"

        fun create(): Api {

            val restAdapter = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient(provideLoggingInterceptor()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


            return restAdapter.create(Api::class.java)
        }

        private fun okHttpClient(
                interceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
                .run {
                    addInterceptor(interceptor)
                    build()
                }

        private fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }
}