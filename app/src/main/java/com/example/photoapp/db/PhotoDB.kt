package com.example.photoapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.photoapp.model.PhotoItem

@Database(entities = [PhotoItem::class], version = 1)
abstract class PhotoDB : RoomDatabase() {

    abstract fun getPhotoData(): PhotoDAO
}