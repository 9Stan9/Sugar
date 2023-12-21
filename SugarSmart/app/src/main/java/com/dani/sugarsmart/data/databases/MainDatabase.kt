package com.dani.sugarsmart.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dani.sugarsmart.data.calories.dao.CalorieEntryDAO
import com.dani.sugarsmart.data.calories.dto.CalorieEntryDTO
import com.dani.sugarsmart.data.medicine.dao.MedicineInfoEntryDAO
import com.dani.sugarsmart.data.medicine.dto.MedicineInfoEntryDTO
import com.dani.sugarsmart.data.physical.dao.PhysicalActivityEntryDAO
import com.dani.sugarsmart.data.physical.dto.PhysicalActivityEntryDTO
import com.dani.sugarsmart.data.sugar.dao.SugarEntryDAO
import com.dani.sugarsmart.data.sugar.dto.SugarEntryDTO
import com.dani.sugarsmart.data.user.dao.UserDAO
import com.dani.sugarsmart.data.user.dto.UserDTO

@Database(
    entities = [SugarEntryDTO::class, PhysicalActivityEntryDTO::class, MedicineInfoEntryDTO::class, CalorieEntryDTO::class, UserDTO::class],
    version = 1
)
@TypeConverters(LocalDateTimeConverter::class)
abstract class MainDatabase : RoomDatabase() {
    abstract val sugarEntryDAO: SugarEntryDAO
    abstract val physicalActivityEntryDAO: PhysicalActivityEntryDAO
    abstract val medicineInfoEntryDAO: MedicineInfoEntryDAO
    abstract val calorieEntryDAO: CalorieEntryDAO
    abstract val userEntryDAO: UserDAO
}