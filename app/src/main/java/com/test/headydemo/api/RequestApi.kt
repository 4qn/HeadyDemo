package com.test.headydemo.api

import com.test.headydemo.model.HeadyResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Furqan on 03-01-2019.
 */
interface RequestApi {
    @GET("json")
    fun fetchData(): Observable<HeadyResponse>
}