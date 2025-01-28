package com.example.hilt_dependency_injection_example.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hilt_dependency_injection_example.models.Product

// DAO (Data Access Object) interface for interacting with the Product database
@Dao
interface ProductDAO {

    // Inserts a list of products into the database. If there's a conflict, it will replace the existing product
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products : List<Product>)

    // Retrieves all products from the database
    @Query("SELECT * FROM Product")
    suspend fun getProducts() : List<Product>

}