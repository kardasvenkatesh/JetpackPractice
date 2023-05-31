package com.example.jetpackprofilepractice

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import com.example.jetpackexample.ui.theme.JetpackExampleTheme
import com.example.navigationdrawercomposeexample.R
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductDetail(
    title: String?, price: String, category: String, image: String, description: String
) {

    JetpackExampleTheme() {

        Scaffold(Modifier.fillMaxSize()) {


            Box(modifier = Modifier.fillMaxSize()) {



                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.dark_grey))
                    .padding(0.dp, 0.dp, 0.dp, 0.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(colorResource(id = R.color.dark_grey))
                    ) {
                        Button(
                            onClick = {

                            },

                            colors = ButtonDefaults.outlinedButtonColors(colorResource(id = R.color.green_color)),
                            shape = RoundedCornerShape(50.dp),

                            modifier = Modifier
                                .height(45.dp)
                                .width(150.dp)
                                .align(Alignment.CenterEnd)
                                .padding(0.dp,0.dp,10.dp,0.dp)
                        ) {
                            Text(text = "Add To Cart", color = Color.White)
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

                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.Black,
                                modifier = Modifier.padding(10.dp, 10.dp, 0.dp, 0.dp)
                            )
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
                                text = description.repeat(4),
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