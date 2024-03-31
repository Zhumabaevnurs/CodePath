package com.example.bitfit

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HealthDAO {
    // Query to get all data from HealthData
    @Query("SELECT * FROM HealthData")
    fun getAll(): LiveData<List<FoodItem>>

    // Insert new item
    @Insert
    fun insert(food: FoodItem)

    // Delete all items from HealthData table
    @Query("DELETE FROM HealthData")
    fun deleteAll()

    // Delete single item from table
    @Delete
    fun deleteItem(food: FoodItem)


}