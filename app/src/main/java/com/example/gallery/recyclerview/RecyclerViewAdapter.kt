package com.example.gallery.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.db.entity.PhotoDto
import com.example.gallery.utils.MyDiffUtil


class RecyclerViewAdapter(
    private var photos: List<PhotoDto>,
    private val callback: Callback
) :
    RecyclerView.Adapter<ViewHolder>() {

    interface Callback {
        fun onItemClicked(item: PhotoDto)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(com.example.gallery.R.layout.item_recycler_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(photos[position].photoUrl)
        holder.itemView.setOnClickListener {
            callback.onItemClicked(photos[position])
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