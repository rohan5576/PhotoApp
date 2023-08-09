package com.example.photoapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.photoapp.db.PhotoDB
import com.example.photoapp.model.PhotoItem
import com.example.photoapp.repository.PhotoRepository
import com.example.photoapp.retrofit.PhotoAPIInterface
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class PhotoRepositoryTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var photoAPIInterface: PhotoAPIInterface

    @Mock
    lateinit var photoDB: PhotoDB

    @Before
    fun setUp(){
      MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testGetPhotos_EmptyList() = runTest{
        Mockito.`when`(photoAPIInterface.getPhotoApi()).thenReturn(Response.success(emptyList()))
        val getPhotoData = PhotoRepository(photoAPIInterface,photoDB)
        val result = getPhotoData.getPhotos()
        Assert.assertEquals(true,result.isSuccessful)
        Assert.assertEquals(0, result.body()!!.size)
    }

    @Test
    fun testGetPhotos_expectedPhotoList() = runTest{

        val photoList = listOf<PhotoItem>(
           PhotoItem("1","Photo 1"," ID first",
                "https://via.placeholder.com/150/92c952","https://via.placeholder.com/600/92c952"),
           PhotoItem("2","Photo 1"," ID first",
                "https://via.placeholder.com/150/92c952","https://via.placeholder.com/600/92c952")
        )
        Mockito.`when`(photoAPIInterface.getPhotoApi()).thenReturn(Response.success(photoList))
        val getPhotoData = PhotoRepository(photoAPIInterface,photoDB)
        val result = getPhotoData.getPhotos()
        Assert.assertEquals(true,result.isSuccessful)
        Assert.assertEquals(2, result.body()!!.size)
        Assert.assertEquals("Photo 1", result.body()!![0].title)
    }
}