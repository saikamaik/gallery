package com.example.gallery.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.gallery.db.entity.PhotoDto

class MyDiffUtil(
    private val oldList: List<PhotoDto>,
    private val newList: List<PhotoDto>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].photoId == newList[newItemPosition].photoId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].photoId != newList[newItemPosition].photoId -> {
                false
            }

            oldList[oldItemPosition].photoUrl != newList[newItemPosition].photoUrl
            -> {
                false
            }

            oldList[oldItemPosition].photoTag != newList[newItemPosition].photoTag -> {
                false
            }
            else -> true
        }
    }
}