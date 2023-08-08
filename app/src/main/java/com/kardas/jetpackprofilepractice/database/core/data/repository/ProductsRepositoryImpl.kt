package ro.alexmamo.roomjetpackcompose.data.repository

import com.kardas.jetpackprofilepractice.database.core.data.dao.ProductDao
import kotlinx.coroutines.flow.Flow
import ro.alexmamo.roomjetpackcompose.domain.model.Product
import ro.alexmamo.roomjetpackcompose.domain.repository.Products
import ro.alexmamo.roomjetpackcompose.domain.repository.ProductsRepository

class ProductsRepositoryImpl(
    private val productDao: ProductDao
) : ProductsRepository {
    override fun getProductFromRoom(): Flow<Products> = productDao.getProducts()

    override suspend fun getProductFromRoom(id: Int): Product {
        TODO("Not yet implemented")
    }

    override suspend fun addProductToRoom(product: Product) = productDao.addProduct(product)

    override suspend fun updateProductInRoom(product: Product) = productDao.updateProduct(product)

    override suspend fun deleteProductFromRoom(product: Product) = productDao.deleteProduct(product)

}