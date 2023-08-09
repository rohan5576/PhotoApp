package com.example.photoapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.photoapp.db.PhotoDAO
import com.example.photoapp.db.PhotoDB
import com.example.photoapp.model.PhotoItem
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PhotoDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    lateinit var photoDAO: PhotoDAO
    lateinit var photoDatabase: PhotoDB

    @Before
    fun setUp(){
           photoDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),PhotoDB::class.java).
                   allowMainThreadQueries().build()
           photoDAO = photoDatabase.getPhotoData()
    }

    @Test
    fun insertPhotoItem_expectedSingleItem() = runTest{
         val itemData = PhotoItem("1","Photo 1"," ID first",
             "https://via.placeholder.com/150/92c952","https://via.placeholder.com/600/92c952")
         val listItem = listOf<PhotoItem>(itemData)
          photoDAO.addPhotos(listItem)


        // check data is inserted or not
        val insertedResult= photoDAO.getPhotos()

        Assert.assertEquals(1,insertedResult.size)
        Assert.assertEquals("Photo 1",insertedResult[0].title)

    }


    @After
    fun tearDown(){
            photoDatabase.close()
    }
}