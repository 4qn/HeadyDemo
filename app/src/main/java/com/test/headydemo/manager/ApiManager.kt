package com.test.headydemo.manager

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by Furqan on 03-01-2019.
 */
class ApiManager {

    companion object {

        private val BASE_URL: String = "https://stark-spire-93433.herokuapp.com"

        private var retrofit: Retrofit? = null

        fun <S> getClient(serviceClass: Class<S>): S {
//            val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            val client = OkHttpClient.Builder()
                /*.addNetworkInterceptor(interceptor)*/
                .build()
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return retrofit!!.create(serviceClass)
        }

    }
}