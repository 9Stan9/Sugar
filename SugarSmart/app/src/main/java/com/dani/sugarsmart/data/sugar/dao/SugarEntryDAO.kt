package com.dani.sugarsmart.data.sugar.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dani.sugarsmart.data.sugar.dto.SugarEntryDTO

@Dao
interface SugarEntryDAO {
    @Insert
    suspend fun insertSugarEntry(sugarEntry: SugarEntryDTO)

    @Query("SELECT * FROM sugar_entries")
    suspend fun readSugarEntries(): List<SugarEntryDTO>

    @Update
    suspend fun updateSugarEntry(sugarEntry: SugarEntryDTO)

    @Delete
    suspend fun deleteSugarEntry(sugarEntry: SugarEntryDTO)
}