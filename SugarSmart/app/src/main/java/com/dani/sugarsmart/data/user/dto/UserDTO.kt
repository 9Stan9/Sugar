package com.dani.sugarsmart.data.user.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDTO(
    @PrimaryKey val id: Long?,
    val login: String,
    val password: String
)
