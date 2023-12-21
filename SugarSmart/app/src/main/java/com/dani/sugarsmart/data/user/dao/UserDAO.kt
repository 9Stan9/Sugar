package com.dani.sugarsmart.data.user.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dani.sugarsmart.data.user.dto.UserDTO

@Dao
interface UserDAO {
    @Insert
    suspend fun insert(user: UserDTO)

    @Query("SELECT * FROM users WHERE login = :login AND password = :password")
    suspend fun getUserByLoginAndPassword(login: String, password: String): UserDTO?

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserDTO>
}
