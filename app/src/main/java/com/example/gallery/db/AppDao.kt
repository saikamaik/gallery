package com.example.gallery.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gallery.db.entity.UserDto

@Dao
interface AppDao {

    @Query("SELECT * FROM userdto")
    fun getAllUsers(): List<UserDto>

    @Query("SELECT * FROM userdto WHERE email = :email")
    fun getOneUser(email: String): UserDto

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(userDto: UserDto)

    @Query("SELECT EXISTS(SELECT * FROM userdto WHERE email = :email)")
    fun isUserExist(email: String): Boolean

    @Query("UPDATE userdto SET current_user=:isCurrentUser WHERE email = :email")
    fun updateCurrentUserField(isCurrentUser: Boolean, email: String)

    @Query("SELECT * FROM userdto WHERE current_user = true")
    fun getCurrentUser(): UserDto

//    fun getAllNewPhotos()
//
//    fun getAllPopularPhotos()

}