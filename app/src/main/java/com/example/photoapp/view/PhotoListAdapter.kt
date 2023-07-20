package com.example.photoapp.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photoapp.databinding.AdapterCustomViewBinding
import com.example.photoapp.model.PhotoItem
import com.example.photoapp.utils.Utils


class PhotoListAdapter(private val data: List<PhotoItem>, private val context : Context) :
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: AdapterCustomViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterCustomViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(data[position]){
                binding.title.text = data[position].title
                val requestOptions = com.bumptech.glide.request.RequestOptions().fitCenter()
                Glide.with(context).load(data[position].thumbnailUrl).apply(requestOptions)
                    .into(binding.coverImage)
                binding.cardViewItem.setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(Utils.PHOTO_LIST_DATA, data[position])
                    context.startActivity(intent)
                }
            }

        }
    }
}