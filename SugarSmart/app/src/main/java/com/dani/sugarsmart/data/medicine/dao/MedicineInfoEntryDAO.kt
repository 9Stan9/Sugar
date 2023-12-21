package com.dani.sugarsmart.data.medicine.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dani.sugarsmart.data.medicine.dto.MedicineInfoEntryDTO

@Dao
interface MedicineInfoEntryDAO {
    @Insert
    suspend fun insertMedicineInfoEntry(medicineInfoEntry: MedicineInfoEntryDTO)

    @Query("SELECT * FROM medicine_info_entries")
    suspend fun readMedicineInfoEntries(): List<MedicineInfoEntryDTO>

    @Update
    suspend fun updateMedicineInfoEntry(medicineInfoEntry: MedicineInfoEntryDTO)

    @Delete
    suspend fun deleteMedicineInfoEntry(medicineInfoEntry: MedicineInfoEntryDTO)
}
