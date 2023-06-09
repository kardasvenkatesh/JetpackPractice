package com.example.jetpackprofilepractice.database.core.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.OnConflictStrategy.IGNORE
import kotlinx.coroutines.flow.Flow
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.PRODUCTS_TABLE
import ro.alexmamo.roomjetpackcompose.domain.model.Product
import ro.alexmamo.roomjetpackcompose.domain.repository.Products

@Dao
interface ProductDao {

    @Query("SELECT * FROM $PRODUCTS_TABLE ORDER BY id ASC")
    fun getProducts(): Flow<Products>

    @Query("SELECT * FROM $PRODUCTS_TABLE WHERE id = :id")
    suspend fun getProducts(id: Int): Product

    @Insert(onConflict = IGNORE)
    suspend fun addProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)
}