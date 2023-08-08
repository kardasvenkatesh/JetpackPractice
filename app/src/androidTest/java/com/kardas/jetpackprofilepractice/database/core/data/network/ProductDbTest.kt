package com.kardas.jetpackprofilepractice.database.core.data.network

import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kardas.jetpackprofilepractice.database.core.data.dao.ProductDao
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ro.alexmamo.roomjetpackcompose.data.network.ProductDb
import ro.alexmamo.roomjetpackcompose.domain.model.Product

@RunWith(AndroidJUnit4::class)
class ProductDbTest : TestCase(){

    private lateinit var db : ProductDb
    private lateinit var dao : ProductDao

    @Before
    public override fun setUp() {
       val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        db = Room.inMemoryDatabaseBuilder(context,ProductDb::class.java).build()
        dao = db.productDao
    }

    @Test
    fun writeAndReadCartProducts() = runBlocking {
        val product = Product(1, "testunit", "100", "", 2)
        dao.addProduct(product)

        val products = dao.getProducts()
        Log.d("getproducts",""+products)
//        assertTrue(products.contains(product))
    }
}