package com.example.photoapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.photoapp.db.PhotoDAO
import com.example.photoapp.db.PhotoDB
import com.example.photoapp.model.PhotoItem
import com.example.photoapp.retrofit.PhotoAPIInterface
import retrofit2.Response
import javax.inject.Inject

class PhotoRepository @Inject constructor(private  val photoAPIInterface: PhotoAPIInterface,
 private val photoDB: PhotoDB){

    private val _photosList = MutableLiveData<List<PhotoItem>>()

    val photos : LiveData<List<PhotoItem>>
        get() = _photosList

    suspend fun getPhotos() : Response<List<PhotoItem>> {
        val result = photoAPIInterface.getPhotoApi()
        if(result.body()!=null&&result.isSuccessful){
             photoDB?.getPhotoData()?.addPhotos(result.body()!!)
            _photosList.postValue(result.body())
        }

        return result
    }


}