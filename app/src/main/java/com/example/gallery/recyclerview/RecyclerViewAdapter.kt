package com.example.gallery.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gallery.databinding.ItemRecyclerViewBinding

class RecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var photos: List<String> = arrayListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent)
    }

    fun setPhotosData(
        photos: List<String>
    ) {
        this.photos = photos
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    class ViewHolder private constructor(
        private val binding: ItemRecyclerViewBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRecyclerViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(photoList: String) {
            binding.img.load(photoList)
        }

    }

    override fun getItemCount(): Int {
        return photos.size
    }
}