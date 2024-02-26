package com.example.gallery.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDto(
    var email: String,
    var password: String,
    @PrimaryKey var username: String,
    var birthday: String?,
    @ColumnInfo(name = "current_user") var isCurrentUser: Boolean
)
