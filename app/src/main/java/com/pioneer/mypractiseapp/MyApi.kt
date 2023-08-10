package com.pioneer.mypractiseapp

import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    @GET("posts")
    suspend fun getPosts(): Response<Album>
}