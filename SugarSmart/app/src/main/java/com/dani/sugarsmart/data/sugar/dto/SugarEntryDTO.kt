package com.dani.sugarsmart.data.sugar.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "sugar_entries")
data class SugarEntryDTO(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val time: LocalDateTime,
    val sugarLevel: Double,
    val eatName: String,
    val eatTime: LocalDateTime
)