package com.example.gallery.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gallery.databinding.ItemRecyclerViewBinding
import com.example.gallery.db.entity.PhotoDto
import com.example.gallery.utils.MyDiffUtil

class RecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var photos: List<PhotoDto> = arrayListOf()
    var onItemClick: ((PhotoDto) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent)
    }

    fun setPhotosData(
        photos: List<PhotoDto>
    ) {
        this.photos = photos
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position].photoUrl)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(photos[position])
        }
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

    fun setData(newPhotoList: List<PhotoDto>) {
        val diffUtil = MyDiffUtil(photos, newPhotoList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        photos = newPhotoList
        diffResults.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}