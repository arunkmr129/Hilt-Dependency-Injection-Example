package com.example.hilt_dependency_injection_example.retrofit

import com.example.hilt_dependency_injection_example.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}