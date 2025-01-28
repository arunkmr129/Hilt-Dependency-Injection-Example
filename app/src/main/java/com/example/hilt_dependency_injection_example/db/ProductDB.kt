package com.example.hilt_dependency_injection_example.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hilt_dependency_injection_example.models.Product

// Room Database class for managing the database and accessing DAO
@Database(entities = [Product::class], version = 1) // Specifies the entities and the database version
abstract class ProductDB : RoomDatabase() {
    // Abstract method to get an instance of the ProductDAO
    abstract fun getProductDAO() : ProductDAO
}