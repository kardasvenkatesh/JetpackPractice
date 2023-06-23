package ro.alexmamo.roomjetpackcompose.domain.repository

import kotlinx.coroutines.flow.Flow
import ro.alexmamo.roomjetpackcompose.domain.model.Product

typealias Products = List<Product>

interface ProductsRepository {
    fun getProductFromRoom(): Flow<Products>

    suspend fun getProductFromRoom(id: Int): Product

    suspend fun addProductToRoom(product: Product)

    suspend fun updateProductInRoom(product: Product)

    suspend fun deleteProductFromRoom(product: Product)
}