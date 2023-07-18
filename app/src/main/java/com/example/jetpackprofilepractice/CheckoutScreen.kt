package com.example.jetpackprofilepractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.jetpackprofilepractice.checkout.CheckOutContent
import com.example.jetpackprofilepractice.components.UpdateProductTopBar
import com.example.jetpackprofilepractice.database.core.data.network.components.ProductsViewModel
import com.example.navigationdrawercomposeexample.R

@Composable
fun CheckoutScreen(navController: NavController, navigateBack: () -> Unit) {

    val viewModel: ProductsViewModel = hiltViewModel()
    val products by viewModel.products.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {

            UpdateProductTopBar("Complete Order",
                navigateBack = navigateBack
            )
        },
        content = { padding ->

            Column(Modifier.fillMaxSize().padding(top = 50.dp)) {
                Box(modifier = Modifier.background(color = colorResource(id = R.color.dark_grey))) {
                    CheckOutContent(
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