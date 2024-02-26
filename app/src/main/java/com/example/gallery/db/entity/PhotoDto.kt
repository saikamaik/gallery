package com.example.gallery.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class PhotoDto(
    @PrimaryKey (autoGenerate = true) var photoId: Int,
    var photoName: String,
    var photoDescription: String?,
    var photoUploadDate: Date?,
    var photoUserID: Int,
//    var photoTags: List<String>?,
    var photoUrl: String,
    var photoType: String
)
