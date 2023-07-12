package com.example.regularshowconstraintlayout.Network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TodoAPI {
    //tell retrforit how to retrive todos
    @GET("/create-a-rest-api-with-json-server-36da8680136d")
   suspend fun getTodos(): Response<List<todo>>


}