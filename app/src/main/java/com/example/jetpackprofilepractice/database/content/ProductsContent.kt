package com.example.jetpackprofilepractice.database.content

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackprofilepractice.database.core.data.network.components.ProductsViewModel
import com.example.navigationdrawercomposeexample.R
import ro.alexmamo.roomjetpackcompose.domain.model.Product
import ro.alexmamo.roomjetpackcompose.domain.repository.Products

@Composable
fun ProductsContent(
    padding: PaddingValues,
    products: Products,
    deleteProduct: (product: Product) -> Unit,
    navigateBack: () -> Unit,
    navController: NavHostController,
) {

//    val navController = rememberNavController()
    val mContext = LocalContext.current


    val viewModel: ProductsViewModel = viewModel()
    Column(Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(padding)
                .background(color = colorResource(id = R.color.dark_grey_light))
        ) {
            items(
                items = products
            ) { product ->
                ProductCard(product = product, deleteProduct = { deleteProduct(product) })

                if (products.size < 1) {
                    navController.popBackStack()
                }


                // cart cardview


            }
        }

        Box(
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp), Alignment.BottomCenter
        ) {
            Row(
                Modifier
                    .background(colorResource(id = R.color.green_color))
                    .fillMaxWidth()
                    .height(50.dp), verticalAlignment = Alignment.CenterVertically

            ) {

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Text(
                        modifier = Modifier.padding(start = 10.dp, top = 0.dp),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 14.sp,
                        text = "Qty : " + "${products.size}" + " | " + viewModel.totalPrice,

                        )
                }

                Spacer(
                    Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .background(colorResource(id = R.color.green_color))
                )

                Log.d("sizeeeee", products.size.toString())


                Image(painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_right_24),
                    contentDescription = "",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .padding(start = 0.dp, end = 10.dp)
                        .clickable {

                            if (products.size > 0) {
                                navController.navigate("CheckoutPage")
                            } else {
                                Toast
                                    .makeText(
                                        mContext,
                                        "Please Addf Something to Cart",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }

//
                        }

                )


            }


        }


    }
}