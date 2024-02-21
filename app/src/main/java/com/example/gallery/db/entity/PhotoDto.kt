package com.example.gallery.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoDto(
    @PrimaryKey (autoGenerate = true) var photoId: Int,
    var photoUrl: String,
    var photoTag: String
)
