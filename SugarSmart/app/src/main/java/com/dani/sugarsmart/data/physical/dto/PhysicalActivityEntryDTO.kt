package com.dani.sugarsmart.data.physical.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "physical_activity_entries")
data class PhysicalActivityEntryDTO(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val time: LocalDateTime,
    val activityType: String,
    val duration: String,
    val intensive: String,
    val distance: Double,
    val pulse: Int,
    val caloriesBurned: Double
)
