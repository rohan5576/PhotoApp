package com.example.photoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photoapp.model.PhotoItem
import com.example.photoapp.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: PhotoRepository) : ViewModel(){

    val photo: LiveData<List<PhotoItem>>
    get() = repository.photos


    init {
        viewModelScope.launch {
            repository.getPhotos()
        }
    }

}