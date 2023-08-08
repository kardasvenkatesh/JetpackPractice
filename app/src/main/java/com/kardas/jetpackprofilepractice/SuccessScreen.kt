package com.kardas.jetpackprofilepractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.navigationdrawercomposeexample.R
import com.kardas.jetpackprofilepractice.components.UpdateProductTopBar
import com.kardas.jetpackprofilepractice.database.core.data.network.components.ProductsViewModel

@Composable
fun SuccessScreen(navController: NavController, navigateBack: () -> Unit) {

    var viewModel: ProductsViewModel = hiltViewModel()

    Scaffold(topBar = {

        UpdateProductTopBar(
            "Complete Order", navigateBack = navigateBack
        )
    }, content = { padding ->

        Box(modifier = Modifier.fillMaxSize()) {

            viewModel.clearUserData()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.dark_grey)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Spacer(modifier = Modifier.height(200.dp))

                Image(
                    painterResource(R.drawable.success),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(100.dp)
                )

                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {

                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            modifier = Modifier
                                .padding(start = 0.dp, top = 0.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 24.sp,
                            text = "Congratulations",
                        )



                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            modifier = Modifier
                                .padding(start = 0.dp, top = 0.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontSize = 14.sp,
                            text = "Your Order Has Been Placed Successffully",
                        )



                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = {
                                    navController.navigate("HomeActivity")
                            },

                            colors = ButtonDefaults.outlinedButtonColors(colorResource(id = R.color.green_color)),
                            shape = RoundedCornerShape(50.dp),

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = "Go Home", color = Color.White)
                        }
                    }

                }


            }


        }
    })
}