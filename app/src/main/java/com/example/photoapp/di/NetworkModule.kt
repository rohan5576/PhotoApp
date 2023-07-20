package com.example.photoapp.di

import com.example.photoapp.retrofit.PhotoAPIInterface
import com.example.photoapp.utils.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit{
       return Retrofit.Builder().baseUrl(Utils.BASE_URL)
           .addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Singleton
    @Provides
    fun getPhotoAPI(retrofit: Retrofit):PhotoAPIInterface{
        return retrofit.create(PhotoAPIInterface::class.java)
    }
}