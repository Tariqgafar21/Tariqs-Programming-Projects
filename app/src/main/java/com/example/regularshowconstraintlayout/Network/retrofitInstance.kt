package com.example.regularshowconstraintlayout.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object retrofitInstance {

    val api: TodoAPI by lazy{
        Retrofit.Builder()
            .baseUrl("https://medium.com/codingthesmartway-com-blog/create-a-rest-api-with-json-server-36da8680136d")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(TodoAPI::class.java)
    }
}