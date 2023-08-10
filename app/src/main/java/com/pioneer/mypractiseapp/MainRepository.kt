package com.pioneer.mypractiseapp

import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(var api: MyApi) {

    suspend fun getAlbums(): Response<Album> {
        return api.getPosts()
    }

}