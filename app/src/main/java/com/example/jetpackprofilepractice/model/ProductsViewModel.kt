package com.example.jetpackprofilepractice.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackprofilepractice.Data.CategoriesItem
import com.example.jetpackprofilepractice.Data.ProductsItem
import com.example.jetpackprofilepractice.network.ApiService
import kotlinx.coroutines.launch

class ProductsViewModel: ViewModel() {

    var productListResponse: List<ProductsItem> by mutableStateOf(listOf())

    fun getAllProducts() {
        viewModelScope.launch {

            try {
                productListResponse = ApiService.getInstance().getAllProducts()

            } catch (e: Exception) {
                Log.e("Error",e.toString())
            }
        }

    }
}