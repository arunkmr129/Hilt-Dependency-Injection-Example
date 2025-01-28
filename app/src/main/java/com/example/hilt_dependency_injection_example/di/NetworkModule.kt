package com.example.hilt_dependency_injection_example.di

import com.example.hilt_dependency_injection_example.retrofit.ProductAPI
import com.example.hilt_dependency_injection_example.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Module class for providing network-related dependencies (Retrofit and API interfaces)
@InstallIn(SingletonComponent::class) // Specifies that this module will be installed in the SingletonComponent (application-level scope)
@Module // Marks this class as a Dagger Hilt module that provides dependencies
class NetworkModule {

    // Provides a single instance of Retrofit that will be injected into classes when needed
    @Singleton // Ensures that only one instance of Retrofit is created throughout the app (singleton pattern)
    @Provides
    fun providesRetrofit() : Retrofit{
        // Creates and returns a Retrofit instance with the base URL and Gson converter factory
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Provides a single instance of ProductAPI that will be injected into classes when needed
    @Singleton
    @Provides
    fun providesProductAPI(retrofit: Retrofit) : ProductAPI {
        return retrofit.create(ProductAPI::class.java)
    }
}