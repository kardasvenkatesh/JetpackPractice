package com.example.jetpackprofilepractice

import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetpackexample.ui.theme.JetpackExampleTheme
import com.example.jetpackprofilepractice.components.ProductsTopBar
import com.example.jetpackprofilepractice.components.UpdateProductTopBar
import com.example.jetpackprofilepractice.database.content.ProductsContent
import com.example.jetpackprofilepractice.database.core.data.network.components.ProductsViewModel
import com.example.navigationdrawercomposeexample.R

@Composable
fun CartPage(navController: NavController, navigateBack: () -> Unit) {

    val viewModel: ProductsViewModel = hiltViewModel()
    val products by viewModel.products.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {

            UpdateProductTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->

            Column(Modifier.fillMaxSize()) {
                Box(modifier = Modifier.background(color = colorResource(id = R.color.dark_grey))) {
                    ProductsContent(
                        padding = padding, products = products, deleteProduct = { product ->
                            viewModel.deleteProduct(product)
                        },

                        navigateBack = navigateBack
                    )


                }
            }


            if (products.size < 1) {

            }


        },
    )

}

