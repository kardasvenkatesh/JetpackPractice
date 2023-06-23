package com.example.jetpackprofilepractice.Data

data class ProductsItem(
    val category: Category,
    val creationAt: String,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Long,
    val title: String,
    val updatedAt: String
)