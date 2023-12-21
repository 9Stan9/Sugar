package com.dani.sugarsmart.data.calories.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dani.sugarsmart.data.calories.dto.CalorieEntryDTO

@Dao
interface CalorieEntryDAO {
    @Insert
    suspend fun insertCalorieEntry(calorieEntry: CalorieEntryDTO)

    @Query("SELECT * FROM calorie_entries")
    suspend fun readCalorieEntries(): List<CalorieEntryDTO>

    @Update
    suspend fun updateCalorieEntry(calorieEntry: CalorieEntryDTO)

    @Delete
    suspend fun deleteCalorieEntry(calorieEntry: CalorieEntryDTO)
}