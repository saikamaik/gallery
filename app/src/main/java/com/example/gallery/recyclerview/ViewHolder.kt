package com.example.gallery.recyclerview

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gallery.R

class ViewHolder(
    private val binding: View
) :
    RecyclerView.ViewHolder(binding) {

    private val img : ImageView = binding.findViewById(R.id.main_img)
    fun bind(photoList: String) {
        img.load(photoList)
    }

}