package com.example.gallery.db

import com.example.gallery.db.entity.UserDto
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {

    fun getOneUser(email: String) : Flow<UserDto>

}