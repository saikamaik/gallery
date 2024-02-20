package com.example.gallery.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoDto(
    @PrimaryKey val url: String,
    val tag: String
)
