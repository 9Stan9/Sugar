package com.dani.sugarsmart.data.medicine.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "medicine_info_entries")
data class MedicineInfoEntryDTO(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val medicineTime: LocalDateTime,
    val medicineName: String,
    val medicineDose: Double,

    val insulinName: String,
    val insulinDose: Double,
    val insulinTime: LocalDateTime
)