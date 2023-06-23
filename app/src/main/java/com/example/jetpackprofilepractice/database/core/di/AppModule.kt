package ro.alexmamo.roomjetpackcompose.di

import android.content.Context
import androidx.room.Room
import com.example.jetpackprofilepractice.database.core.data.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.PRODUCTS_TABLE
import ro.alexmamo.roomjetpackcompose.data.network.ProductDb
import ro.alexmamo.roomjetpackcompose.data.repository.ProductsRepositoryImpl
import ro.alexmamo.roomjetpackcompose.domain.repository.ProductsRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideProductDb(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, ProductDb::class.java, PRODUCTS_TABLE
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideProductDao(
        productDb: ProductDb
    ) = productDb.productDao

    @Provides
    fun provideProductRepository(
        productDao: ProductDao
    ): ProductsRepository = ProductsRepositoryImpl(
        productDao = productDao
    )
}