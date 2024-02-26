package com.example.gallery.db

import com.example.gallery.db.entity.UserDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val appDao: AppDao
)
    : DatabaseRepository {
    override fun getOneUser(email: String): Flow<UserDto> = flow {
        emit(appDao.getOneUser(email))
    }
}