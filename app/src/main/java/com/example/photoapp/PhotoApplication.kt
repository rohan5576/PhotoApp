package com.example.photoapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PhotoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}