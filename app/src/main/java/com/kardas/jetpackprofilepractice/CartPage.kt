package com.kardas.jetpackprofilepractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.navigationdrawercomposeexample.R
import com.kardas.jetpackprofilepractice.components.UpdateProductTopBar
import com.kardas.jetpackprofilepractice.database.content.ProductsContent
import com.kardas.jetpackprofilepractice.database.core.data.network.components.ProductsViewModel

@Composable
fun CartPage(navController: NavController, navigateBack: () -> Unit) {

    val viewModel: ProductsViewModel = hiltViewModel()
    val products by viewModel.products.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {

            UpdateProductTopBar("My Cart",
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

                        navigateBack = navigateBack,navController = navController as NavHostController
                    )


                }
            }


            if (products.size < 1) {

            }


        },
    )

}

