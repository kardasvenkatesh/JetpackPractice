package ro.alexmamo.roomjetpackcompose.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kardas.jetpackprofilepractice.database.core.data.dao.ProductDao
import ro.alexmamo.roomjetpackcompose.domain.model.Product

val migration1to2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Perform necessary database schema changes or data migration here
    }
}

@Database(
    entities = [Product::class],
    version = 4,
    exportSchema = false
)
abstract class ProductDb : RoomDatabase() {
    abstract val productDao: ProductDao
}