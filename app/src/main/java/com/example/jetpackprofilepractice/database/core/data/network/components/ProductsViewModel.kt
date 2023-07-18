package com.example.jetpackprofilepractice.database.core.data.network.components

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackprofilepractice.Data.Products
import com.example.jetpackprofilepractice.database.core.data.dao.ProductDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.EMPTY_STRING
import ro.alexmamo.roomjetpackcompose.domain.model.Product
import ro.alexmamo.roomjetpackcompose.domain.repository.ProductsRepository
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repo: ProductsRepository, private val productDao: ProductDao
) : ViewModel() {
    var product by mutableStateOf(Product(0, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, 0))
        private set
    var openDialog by mutableStateOf(false)

    val products = repo.getProductFromRoom()

    fun getProduct(id: Int) = viewModelScope.launch {
        product = repo.getProductFromRoom(id)
    }

    fun addProduct(product: Product) = viewModelScope.launch {
        repo.addProductToRoom(product)
    }

    fun updateProduct(product: Product) = viewModelScope.launch {
        repo.updateProductInRoom(product)
    }

    fun deleteProduct(product: Product) = viewModelScope.launch {
        repo.deleteProductFromRoom(product)
    }

    fun updateTitle(title: String) {
        product = product.copy(
            title = title
        )
    }

    fun updateAuthor(title: String) {
        product = product.copy(
            title = title
        )
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    var totalPrice by mutableStateOf(0.0)
        private set

    init {
        fetchTotalPrice()
    }

    fun fetchTotalPrice() {
        viewModelScope.launch(Dispatchers.IO) {
            totalPrice = productDao.getTotalPrice()

            Log.d("totalPrice", "" + totalPrice)
        }
    }


    fun clearUserData() {
        viewModelScope.launch {
            productDao.deleteAllUsers()
        }
    }
}