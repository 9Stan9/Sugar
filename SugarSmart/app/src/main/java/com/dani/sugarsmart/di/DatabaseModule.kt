package com.dani.sugarsmart.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.dani.sugarsmart.data.calories.dao.CalorieEntryDAO
import com.dani.sugarsmart.data.databases.MainDatabase
import com.dani.sugarsmart.data.medicine.dao.MedicineInfoEntryDAO
import com.dani.sugarsmart.data.physical.dao.PhysicalActivityEntryDAO
import com.dani.sugarsmart.data.sugar.dao.SugarEntryDAO
import com.dani.sugarsmart.data.user.dao.UserDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MainDatabase {
        return Room.databaseBuilder(
            context = context,
            MainDatabase::class.java,
            "my_database"
        ).allowMainThreadQueries().build()
    }

    @Provides
    fun provideSugarEntryDAO(database: MainDatabase): SugarEntryDAO {
        return database.sugarEntryDAO
    }

    @Provides
    fun providePhysicalActivityEntryDAO(database: MainDatabase): PhysicalActivityEntryDAO {
        return database.physicalActivityEntryDAO
    }

    @Provides
    fun provideMedicineInfoEntryDAO(database: MainDatabase): MedicineInfoEntryDAO {
        return database.medicineInfoEntryDAO
    }

    @Provides
    fun provideCalorieEntryDAO(database: MainDatabase): CalorieEntryDAO {
        return database.calorieEntryDAO
    }
    @Provides
    fun provideUserDAO(database: MainDatabase): UserDAO {
        return database.userEntryDAO
    }

}
