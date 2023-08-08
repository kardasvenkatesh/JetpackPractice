package com.kardas.jetpackprofilepractice.database.content

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.kardas.jetpackprofilepractice.database.core.data.network.components.ProductsViewModel
import ro.alexmamo.roomjetpackcompose.domain.model.Product


import com.example.navigationdrawercomposeexample.R

@Composable
fun ProductCard(
    product: Product, deleteProduct: () -> Unit
) {

    var viewModel: ProductsViewModel = hiltViewModel()
    var count by remember { mutableStateOf(0) }
    val navController = rememberNavController()

    Card(

        shape = RoundedCornerShape(20.dp), elevation = CardDefaults.cardElevation(
            defaultElevation = 50.dp
        ), modifier = Modifier
            .height(120.dp)
            .padding(10.dp)
            .clickable {


            }) {


        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(0.dp)
                .background(colorResource(id = R.color.dark_grey)),
        ) {
            AsyncImage(

                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .height(70.dp)
                    .width(90.dp)
                    .padding(start = 15.dp)
                    .align(alignment = Alignment.CenterVertically)
                    .clip(RoundedCornerShape(15.dp))

            )
            Row(
                modifier = Modifier.padding(start = 20.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = product.title, style = TextStyle(
                            color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold
                        )
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "$" + product.cost.toString(), style = TextStyle(
                            color = Color.White, fontSize = 14.sp
                        )
                    )

                    Text(
                        text = "385 KM away", style = TextStyle(
                            color = Color.White, fontSize = 14.sp
                        )
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    IconButton(
                        onClick = {

                            val product = Product(
                                product.id,
                                product.title,
                                product.cost,
                                product.image,
                                product.count
                            )
                            viewModel.deleteProduct(product)

                        }, modifier = Modifier
                            .weight(1f)
                            .padding(end = 0.dp)
                    ) {
                        Icon(Icons.Default.Delete, tint = Color.White, contentDescription = null)
                    }

                    Box(

                        modifier = Modifier
                            .width(100.dp)
                            .height(38.dp)
                            .padding(0.dp, 0.dp, 5.dp, 0.dp)
                            .background(color = Color.Transparent)
                            .padding(bottom = 5.dp), contentAlignment = Alignment.CenterEnd
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(35.dp)
                                .border(
                                    1.dp, color = Color.White, RoundedCornerShape(24.dp)
                                )
                                .wrapContentSize(Alignment.BottomStart),
                            contentAlignment = Alignment.BottomEnd
                        ) {

                            Image(painter = painterResource(id = R.drawable.baseline_remove_circle_24),
                                contentDescription = "",
                                modifier = Modifier
                                    .height(35.dp)
                                    .width(35.dp)
                                    .align(Alignment.CenterStart)
                                    .padding(bottom = 1.dp)
                                    .clickable {
                                        count = product.count
                                        count--

                                        val product = Product(
                                            product.id,
                                            product.title,
                                            product.cost,
                                            product.image,
                                            count
                                        )

                                        if (product != null) {
                                            Log.d("countt+++", "" + product)
                                            viewModel.updateProduct(product)
                                        }
                                        if (count < 1) {
                                            viewModel.deleteProduct(product)

                                        }


                                    }

                            )

                        }

                        Text(
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily.Default,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            ),
                            text = "${product.count}",
                            modifier = Modifier.align(Alignment.Center)

                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(35.dp)
                                .border(
                                    1.dp, color = Color.White, RoundedCornerShape(24.dp)
                                )
                                .wrapContentSize(Alignment.BottomEnd),
                        ) {
                            Image(

                                painter = painterResource(id = R.drawable.baseline_add_circle_24),
                                contentDescription = "",
                                modifier = Modifier
                                    .height(35.dp)
                                    .width(35.dp)
                                    .align(Alignment.CenterEnd)
                                    .padding(bottom = 1.dp)
                                    .clickable {
                                        count = product.count
                                        count++

                                        val product = Product(
                                            product.id,
                                            product.title,
                                            product.cost,
                                            product.image,
                                            count
                                        )

                                        if (product != null) {
                                            Log.d("countt+++", "" + product)
                                            viewModel.updateProduct(product)
                                        }

                                    }

                            )
                        }


                    }


                }

            }

            Row(

            ) {
                AsyncImage(

                    model = R.drawable.baseline_delete_outline_24,
                    contentDescription = null,
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                        .align(alignment = Alignment.CenterVertically)
                        .clip(RoundedCornerShape(15.dp))

                )
            }
        }
    }
}


@Preview
@Composable
fun ProductCardPreview() {
    val navController = rememberNavController()

    MaterialTheme {
        Surface {}
    }
}
