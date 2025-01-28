package com.example.hilt_dependency_injection_example.di

import android.content.Context
import androidx.room.Room
import com.example.hilt_dependency_injection_example.db.ProductDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Module class for providing the ProductDB instance using Dagger Hilt
@InstallIn(SingletonComponent::class) // Specifies that this module will be installed in the SingletonComponent (application-level scope)
@Module // Marks this class as a Dagger Hilt module that provides dependencies
class DatabaseModule {
    // Provides a single instance of ProductDB that will be injected into classes when needed
    @Singleton // Ensures that only one instance of ProductDB is created throughout the app (singleton pattern)
    @Provides // Marks this function as a provider method for ProductDB
    fun provideProductDB(@ApplicationContext context : Context) : ProductDB {
        // Creates and returns a ProductDB instance using the Room database builder
        return Room.databaseBuilder(context, ProductDB::class.java, "ProductDB").build() // Builds and returns the ProductDB instance
    }
}