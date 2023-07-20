package com.example.photoapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class PhotoItem (
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val title:String?=null,
    var albumId: String? = null,
    var thumbnailUrl: String? = null,
    var url: String? = null
) :Parcelable