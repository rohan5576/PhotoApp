package com.example.photoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.photoapp.databinding.ActivityDetailBinding
import com.example.photoapp.model.PhotoItem
import com.example.photoapp.utils.Utils

class DetailActivity : AppCompatActivity() {

     private lateinit var detailBinding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val item: PhotoItem? = intent.getParcelableExtra(Utils.PHOTO_LIST_DATA)

        val requestOptions = com.bumptech.glide.request.RequestOptions().fitCenter()
        Glide.with(this).load(item?.thumbnailUrl).apply(requestOptions)
            .into(detailBinding.imageView)

        detailBinding.textViewHeader.text = item?.albumId
        detailBinding.textViewDescription.text = item?.title


    }
}