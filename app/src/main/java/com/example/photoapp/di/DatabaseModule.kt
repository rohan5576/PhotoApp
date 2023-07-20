package com.example.photoapp.di

import android.content.Context
import androidx.room.Room
import com.example.photoapp.db.PhotoDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providePhotoDB(@ApplicationContext context : Context) : PhotoDB{
        return Room.databaseBuilder(context, PhotoDB::class.java, "PhotoDB").build()
    }
}