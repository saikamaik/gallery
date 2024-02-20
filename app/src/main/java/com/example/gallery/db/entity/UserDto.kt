package com.example.gallery.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.util.Date

@Entity
data class UserDto(
    var email: String,
    var password: String,
    @PrimaryKey var username: String,
    var birthday: String?,
    @ColumnInfo(name = "current_user") var isCurrentUser: Boolean
)

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}
