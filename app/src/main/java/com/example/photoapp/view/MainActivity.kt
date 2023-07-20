package com.example.photoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photoapp.R
import com.example.photoapp.databinding.ActivityDetailBinding
import com.example.photoapp.databinding.ActivityMainBinding
import com.example.photoapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        loadRecyclerView()
    }

    private fun loadRecyclerView() {
        mainBinding.albumsRecyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.photo.observe(this, Observer {
            it?.let {
                mainBinding.albumsRecyclerView.adapter = PhotoListAdapter(it,this)
            }
        })
    }
}