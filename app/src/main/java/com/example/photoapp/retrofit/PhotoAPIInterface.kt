package com.example.photoapp.retrofit

import com.example.photoapp.model.PhotoItem
import retrofit2.Response
import retrofit2.http.GET

interface PhotoAPIInterface {

    @GET("Photos")
    suspend fun getPhotoApi() :Response<List<PhotoItem>>
}