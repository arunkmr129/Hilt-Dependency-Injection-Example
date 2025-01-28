package com.example.hilt_dependency_injection_example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hilt_dependency_injection_example.db.ProductDB
import com.example.hilt_dependency_injection_example.models.Product
import com.example.hilt_dependency_injection_example.retrofit.ProductAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productAPI: ProductAPI,
    private val productDB: ProductDB
) {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts() {
        val result = productAPI.getProducts()
        if (result.isSuccessful && result.body() != null) {
            productDB.getProductDAO().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }

}