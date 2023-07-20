package com.example.photoapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.photoapp.model.PhotoItem

@Dao
interface PhotoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPhotos(photoList : List<PhotoItem>)

    @Query("SELECT * FROM PhotoItem")
    suspend fun getPhotos() : List<PhotoItem>
}