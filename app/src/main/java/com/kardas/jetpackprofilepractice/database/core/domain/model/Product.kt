package ro.alexmamo.roomjetpackcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.PRODUCTS_TABLE

@Entity(tableName = PRODUCTS_TABLE)
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val cost: String,
    val image: String,
    val count: Int
)