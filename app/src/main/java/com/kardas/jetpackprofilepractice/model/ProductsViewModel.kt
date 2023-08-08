package com.kardas.jetpackprofilepractice.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kardas.jetpackprofilepractice.Data.ProductsItem
import com.kardas.jetpackprofilepractice.network.ApiService
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