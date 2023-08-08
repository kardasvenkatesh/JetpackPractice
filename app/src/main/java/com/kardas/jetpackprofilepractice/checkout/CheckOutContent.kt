package com.kardas.jetpackprofilepractice.checkout

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.navigationdrawercomposeexample.R
import com.kardas.jetpackprofilepractice.database.core.data.network.components.ProductsViewModel
import ro.alexmamo.roomjetpackcompose.domain.model.Product

@Composable
fun CheckOutContent(
    padding: PaddingValues,
    products: List<Product>,
    deleteProduct: (product: Product) -> Unit,
    navigateBack: () -> Unit,
    navController: NavHostController
) {

    val viewModel: ProductsViewModel = viewModel()
    val discount = 10
    var subTotal = 0.0
    var tax = 10.0
    var taxAmount = 0.0
    var totalAmount = 0.0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.dark_grey_light))
            .padding(0.dp, 0.dp, 0.dp, 0.dp)
    ) {

        Column(verticalArrangement = Arrangement.Top, modifier = Modifier.background(color = colorResource(id = R.color.dark_grey_light))) {

            Spacer(modifier = Modifier.height(5.dp))

            var fontnames = FontFamily(Font(R.font.volkarne_bold))

            Text(
                text = "Delivering To",
                modifier = Modifier
                    .padding(5.dp)
                    .padding(start = 10.dp, top = 10.dp),
                style = TextStyle(fontSize = 18.sp, color = Color.White, fontFamily = fontnames)
            )

            Card(shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(
                defaultElevation = 40.dp
            ), modifier = Modifier
                .height(170.dp)
                .padding(10.dp)
                .clickable {

                }) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(0.dp)
                        .background(colorResource(id = R.color.dark_grey)),
                ) {

                    Column(
                        modifier = Modifier
                            .weight(2f)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {


                        Row(
                            modifier = Modifier.padding(start = 10.dp)
                        ) {

                            AsyncImage(

                                model = R.drawable.avatar_icon,
                                contentDescription = null,
                                modifier = Modifier
                                    .height(70.dp)
                                    .width(70.dp)
                                    .padding(start = 10.dp)
                                    .clip(RoundedCornerShape(90.dp))

                            )

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .align(alignment = Alignment.CenterVertically)
                                    .padding(start = 20.dp)
                            ) {
                                Text(
                                    text = "Kardas Venkatesh", style = TextStyle(
                                        color = Color.White,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                )
                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "+91-9966308879", style = TextStyle(
                                        color = Color.White, fontSize = 16.sp
                                    )
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Plot No : 29, Adarsh Nagar Colony, Gajularamaram",
                                    style = TextStyle(
                                        color = Color.White, fontSize = 16.sp
                                    )
                                )

                            }

                            Spacer(modifier = Modifier.height(10.dp))


                        }

                    }
                }
            }

            var fontname = FontFamily(Font(R.font.volkarne_bold))

            Text(
                text = "Offers & Benefits",
                modifier = Modifier
                    .padding(5.dp)
                    .padding(start = 10.dp),
                style = TextStyle(fontSize = 18.sp, color = Color.White, fontFamily = fontname)
            )

            Card(shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 50.dp
                ),
                modifier = Modifier
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(10.dp)
                    .clickable {

                    }) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.dark_grey)),
                    contentAlignment = Alignment.TopStart
                ) {

                    Column(
                        modifier = Modifier
                            .background(color = colorResource(id = R.color.dark_grey))
                            .padding(5.dp)
                    ) {

                        Row(
                            modifier = Modifier.background(color = colorResource(id = R.color.dark_grey))
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                                    .background(color = colorResource(id = R.color.dark_grey))

                            ) {
                                Image(
                                    painter = painterResource(R.drawable.baseline_local_offer_24),
                                    contentDescription = null,
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                                Text(
                                    text = "MISSEDYOU",
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .weight(1f),
                                    style = TextStyle(
                                        fontSize = 16.sp, color = Color.White, fontFamily = fontname
                                    )
                                )

                                Text(
                                    text = "Apply",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(0.dp)
                                        .weight(0.2f),
                                    style = TextStyle(
                                        fontSize = 16.sp, color = Color.White, fontFamily = fontname
                                    )
                                )
                            }


                        }

                        Text(
                            text = "Save another 100 on this order",
                            modifier = Modifier.padding(start = 10.dp),
                            style = TextStyle(
                                fontSize = 12.sp, color = Color.White
                            )
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                        Canvas(
                            Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                        ) {

                            drawLine(
                                color = Color.White,
                                start = Offset(0f, 0f),
                                end = Offset(size.width, 0f),
                                pathEffect = pathEffect
                            )
                        }

                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(

                                text = "View All Offers",
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth(),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )

                        }


                    }
                }


            }

            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 50.dp
                ),
                modifier = Modifier
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(10.dp)
                    .background(color = colorResource(id = R.color.dark_grey)),
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.dark_grey)),
                    contentAlignment = Alignment.TopStart
                ) {

                    Row(modifier = Modifier.background(color = colorResource(id = R.color.dark_grey))) {

                        Column(
                            Modifier
                                .weight(1f)
                                .background(color = colorResource(id = R.color.dark_grey))
                                .padding(top = 10.dp, bottom = 10.dp)
                        ) {

                            Text(
                                text = "No Of Items",
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )


                            Text(
                                text = "Items Cost",
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )

                            Text(
                                text = "Discount",
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )

                            Text(
                                text = "Subtotal",
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )

                            Text(
                                text = "Tax",
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )

                            Text(
                                text = "Total",
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )

                        }

                        Column(
                            Modifier
                                .weight(1f)
                                .background(color = colorResource(id = R.color.dark_grey))
                                .padding(top = 10.dp, bottom = 10.dp)
                        ) {

                            Text(
                                text = "${products.size}\"",
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )


                            Text(
                                text = "" + viewModel.totalPrice,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )

                            Text(
                                text = ""+discount,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )

                            subTotal = viewModel.totalPrice - discount

                            Text(
                                text = ""+subTotal,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )

                            taxAmount = tax * subTotal/100

                            Text(
                                text = ""+taxAmount,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )

                            totalAmount = subTotal + taxAmount

                            Text(
                                text = ""+totalAmount,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .padding(5.dp),
                                style = TextStyle(
                                    fontSize = 16.sp, color = Color.White
                                )
                            )

                        }


                    }


                }

            }



        }

        Box(
            modifier = Modifier.padding(0.dp, 80.dp, 0.dp, 0.dp).clickable {    navController.navigate("CheckoutPage") }, Alignment.BottomCenter
        ) {
            Row(
                Modifier
                    .background(colorResource(id = R.color.green_color))
                    .fillMaxWidth()
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Text(
                        modifier = Modifier.padding(start = 10.dp, top = 0.dp).fillMaxWidth().clickable {    navController.navigate("SuccessPage") },
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 18.sp,
                        text = "Proceed To Place Order",

                        )
                }

                Spacer(
                    Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .background(colorResource(id = R.color.green_color)))


                Image(painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_right_24),
                    contentDescription = "",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .padding(start = 0.dp, end = 10.dp)
                        .clickable {
                                navController.navigate("SuccessPage")
//
                        }

                )


            }


        }
    }

}