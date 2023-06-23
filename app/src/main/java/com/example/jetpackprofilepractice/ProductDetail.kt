package com.example.jetpackprofilepractice

import android.annotation.SuppressLint
import android.graphics.drawable.shapes.Shape
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.RoundedCorner
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import com.example.jetpackexample.ui.theme.JetpackExampleTheme
import com.example.navigationdrawercomposeexample.R
import com.google.accompanist.pager.ExperimentalPagerApi
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.HdrPlus
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.unit.dp
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.draw.drawBehind
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.jetpackprofilepractice.database.core.data.network.components.ProductsViewModel
import ro.alexmamo.roomjetpackcompose.domain.model.Product

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceType")
@Composable
fun ProductDetail(
    id: Int,
    description: String,
    title: String?,
    price: String,
    category: String,
    navController: NavHostController,
    image: String,
) {

    var isVisible by remember { mutableStateOf(true) }
    var count by remember { mutableStateOf(0) }

    var viewModel: ProductsViewModel = hiltViewModel()

    val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val roundedShape = RoundedCornerShape(8.dp)

    JetpackExampleTheme() {

        val products by viewModel.products.collectAsState(
            initial = emptyList()
        )

        Log.d(
            "ccccccccc",
            title + "," + category + "," + image + "," + description + ",  cdcdcd" + products.size +","+ id
        )

        Scaffold(Modifier.fillMaxSize()) {


            Box(modifier = Modifier.fillMaxSize()) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.dark_grey))
                        .padding(0.dp, 0.dp, 0.dp, 0.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End
                ) {


                    Box(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                    ) {

                        Row(

                        ) {

                            Box(
                                modifier = Modifier
                                    .height(45.dp)
                                    .width(45.dp)

                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(start = 40.dp, top = 5.dp)
                                        .height(12.dp)
                                        .width(12.dp)
                                        .drawBehind {
                                            drawCircle(
                                                color = Color.White, radius = this.size.maxDimension
                                            )
                                        },
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    fontSize = 10.sp,
                                    text = "${products.size}",

                                    )

                                Image(painter = painterResource(id = R.drawable.baseline_shopping_bag_24),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(45.dp)
                                        .width(45.dp)
                                        .padding(start = 10.dp)
                                        .clickable {
                                            navController.navigate("CartPage")
                                        }

                                )
                            }

                        }

                        //plus and plus functionality

// Add to cart button

                        Box(

                            modifier = Modifier
                                .size(150.dp)
                                .height(45.dp)
                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                .align(alignment = Alignment.CenterEnd)
                                .background(color = Color.Transparent)
                                .padding(end = 10.dp, bottom = 10.dp),
                            contentAlignment = Alignment.CenterEnd
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(150.dp)
                                    .fillMaxWidth()
                                    .height(45.dp)
                                    .border(
                                        1.dp, color = Color.White, RoundedCornerShape(24.dp)
                                    )
                                    .wrapContentSize(Alignment.BottomStart),
                                contentAlignment = Alignment.BottomEnd
                            ) {

                                Image(painter = painterResource(id = R.drawable.baseline_remove_circle_24),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(45.dp)
                                        .width(45.dp)
                                        .align(Alignment.CenterStart)
                                        .padding(bottom = 2.dp)
                                        .clickable {
                                            count--
                                            if (count < 1) {
                                                isVisible = true
                                            }
                                        }

                                )

                            }

                            Text(
                                color = Color.White, style = TextStyle(
                                    fontSize = 22.sp,
                                    fontFamily = FontFamily.Default,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold
                                ), text = "$count", modifier = Modifier.align(Alignment.Center)

                            )

                            Box(
                                modifier = Modifier
                                    .size(150.dp)
                                    .fillMaxWidth()
                                    .height(45.dp)
                                    .border(
                                        1.dp, color = Color.White, RoundedCornerShape(24.dp)
                                    )
                                    .wrapContentSize(Alignment.BottomEnd),
                            ) {
                                Image(

                                    painter = painterResource(id = R.drawable.baseline_add_circle_24),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(45.dp)
                                        .width(45.dp)
                                        .align(Alignment.CenterEnd)
                                        .padding(bottom = 2.dp)
                                        .clickable {
                                            count++

                                            val product = title?.let { it1 ->
                                                Product(
                                                    id, it1, price, image, count
                                                )
                                            }
                                            if (product != null) {
                                                Log.d("countt+++", "" + product)
                                                viewModel.updateProduct(product)
                                            }
                                        }

                                )
                            }


                        }

                        if (isVisible == true) {
                            Box(

                                modifier = Modifier
                                    .size(150.dp)
                                    .height(45.dp)
                                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                    .align(alignment = Alignment.CenterEnd)
                                    .padding(end = 10.dp, bottom = 10.dp)
                                    .border(
                                        1.dp, color = Color.White, RoundedCornerShape(24.dp)
                                    ), contentAlignment = Alignment.CenterEnd
                            ) {

                                Button(
                                    onClick = {
                                        count++
                                        isVisible = false

                                        val product = title?.let { it1 ->
                                            Product(
                                                id, it1, price, image, count
                                            )
                                        }
                                        if (product != null) {
                                            viewModel.addProduct(product)
                                        }
                                    },
                                    modifier = Modifier
                                        .size(150.dp)
                                        .height(45.dp)
                                        .fillMaxWidth()
                                        .clickable { },
                                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.black))

                                ) {
                                    Text(text = "Add To Cart")
                                }

                            }
                        }


                    }

                }

                Column(
                    modifier = Modifier
                        .background(color = colorResource(id = R.color.dark_grey))
                        .padding(0.dp, 0.dp, 0.dp, 0.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    val painter = rememberImagePainter(data = image, builder = {
//                    placeholder(R.drawable.ic_launcher_background)
                    })

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 20.dp)
                    ) {

                        Image(
                            painter = painter,
                            contentDescription = "",
                            Modifier
                                .padding(0.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )

                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.Black,
                                modifier = Modifier
                                    .padding(10.dp, 10.dp, 0.dp, 0.dp)
                                    .clickable { })
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 0.dp, 0.dp, 20.dp)
                    ) {

                        Text(
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily.Default,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            ),
                            text = title.toString(),

                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(10.dp, 10.dp, 0.dp, 0.dp)
                        )

                        Text(
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily.Default,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            ),
                            text = "$" + price,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(0.dp, 10.dp, 30.dp, 0.dp)
                                .align(alignment = Alignment.CenterEnd)

                        )


                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp, 0.dp, 0.dp, 0.dp)

                    ) {

                        Column() {
                            Text(
                                color = Color.White,
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily.Default,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold
                                ),
                                text = "Description",
                                textDecoration = TextDecoration.Underline,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.width(IntrinsicSize.Min),

                                )


                            Text(
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily.Default,
                                    color = Color.White,
                                ),
                                text = description,
                                modifier = Modifier
                                    .padding(0.dp, 5.dp, 10.dp, 0.dp)
                                    .weight(
                                        weight = 1f, fill = false
                                    ),
                                textAlign = TextAlign.Justify,
                            )
                        }


                    }


                }

            }


//    Box(modifier = Modifier.fillMaxSize()) {
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(color = colorResource(id = R.color.dark_grey)),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = CenterHorizontally
//        ) {
//
//            Text(text = "Navigation with arguments", Modifier.padding(10.dp), color = Color.Black)
//
//            Log.d("imagettext", "," + counter)
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight()
//                    .padding(0.dp)
//                    .background(colorResource(id = R.color.dark_grey_light)),
//            ) {
//                Box(contentAlignment = Alignment.BottomCenter) {
//
////                    val painter = rememberImagePainter(data = image, builder = {
//////                    placeholder(R.drawable.ic_launcher_background)
////                    })
////                    Image(
////                        painter = painter,
////                        contentDescription = "",
////                        Modifier
////                            .padding(8.dp)
////                            .clip(RoundedCornerShape(10.dp))
////                            .fillMaxSize(),
////                        contentScale = ContentScale.Crop
////                    )
//
////
//                }
//
//            }
//
//
////             Display the counter
//            Text(
//                text = "Settings Screen, passed data is 1223 $counter",
//                Modifier.padding(10.dp),
//                color = Color.Black
//            )
//        }
//    }
        }
    }
}

@Composable
fun AdvertView(modifier: Modifier = Modifier) {
    Text(
        text = "This is the banner",
        textAlign = TextAlign.Center,
        modifier = modifier.background(Color.Blue),

        )

}

//@Preview
//@Composable
//fun MyDetailScreenPreview() {
//    val navController = rememberNavController()
//
//    MaterialTheme {
//        Surface {
//            ProductDetail("a", "b", "c", "d", "e", navController)
//        }
//    }
//}

@Composable
fun GoneExample(visible: Boolean) {
    if (visible) {
        Text(text = "Visible Content")
    } else {
        Spacer(modifier = Modifier.size(0.dp))
    }
}

