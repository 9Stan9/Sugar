package com.dani.sugarsmart.data.calories.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "calorie_entries")
data class CalorieEntryDTO(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val time: LocalDateTime,
    val caloriesConsumed: Double
)
