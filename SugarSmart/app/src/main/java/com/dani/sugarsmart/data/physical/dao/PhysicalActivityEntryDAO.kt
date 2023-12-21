package com.dani.sugarsmart.data.physical.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dani.sugarsmart.data.physical.dto.PhysicalActivityEntryDTO

@Dao
interface PhysicalActivityEntryDAO {
    @Insert
    suspend fun insertPhysicalActivityEntry(physicalActivityEntry: PhysicalActivityEntryDTO)

    @Query("SELECT * FROM physical_activity_entries")
    suspend fun readPhysicalActivityEntries(): List<PhysicalActivityEntryDTO>

    @Update
    suspend fun updatePhysicalActivityEntry(physicalActivityEntry: PhysicalActivityEntryDTO)

    @Delete
    suspend fun deletePhysicalActivityEntry(physicalActivityEntry: PhysicalActivityEntryDTO)
}