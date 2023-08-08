package com.kardas.jetpackprofilepractice.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kardas.jetpackprofilepractice.Data.CategoriesItem
import com.kardas.jetpackprofilepractice.network.ApiService
import kotlinx.coroutines.launch

class CategoryViewModel: ViewModel() {

    var categoryListResponse: List<CategoriesItem> by mutableStateOf(listOf())

    fun getAllCategories() {
        viewModelScope.launch {

            try {
                categoryListResponse = ApiService.getInstance().getAllCategories()

            } catch (e: Exception) {
                Log.e("Error",e.toString())
            }
        }

    }
}