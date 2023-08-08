package com.kardas.jetpackprofilepractice

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.InstallMobile
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navigationdrawercomposeexample.R

@Composable
fun NewLoginScreen(navController: NavController) {

    val mContext = LocalContext.current
    var fontname = FontFamily(Font(R.font.volkarne_bold))


    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.dark_grey)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            val username = remember { mutableStateOf("") }

            Text(
                text = "Welcome to Locaticus",
                style = TextStyle(fontSize = 30.sp, color = Color.White, fontFamily = fontname)
            )

            Spacer(modifier = Modifier.height(100.dp))


            Image(
                painterResource(R.drawable.mobile_icon),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(80.dp))

            Text(
                modifier = Modifier.padding(30.dp).fillMaxWidth(), textAlign = TextAlign.Center,
                text = "Enter Your Mobile Number To Proceed Further",

                style = TextStyle(fontSize = 16.sp, color = Color.White),

            )


            TextField(
                value = username.value,
//                onValueChange = {
//                    username.value = it.isDigitsOnly().toString()
////                    showError = false
//                },

                onValueChange = { newValue ->
                    username.value = newValue.filter { it.isDigit() }
                },

                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.InstallMobile, contentDescription = "Email Icon"
                    )
                },

                modifier = Modifier
                    .background(
                        color = Color(R.color.dark_grey_light), RoundedCornerShape(percent = 50)
                    )
                    .width(350.dp)
                    .height(60.dp),
                textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
                label = { Text("Enter Mobile No.") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

//                isError = showError,
//                visualTransformation = if (showError) VisualTransformation.None else VisualTransformation.None, // Optional: Hides input text when showing error
//                colors = TextFieldDefaults.textFieldColors(
//                    focusedIndicatorColor = Color.Transparent, // Optional: Hide the focus indicator when showing error
//                    unfocusedIndicatorColor = Color.Transparent, // Optional: Hide the focus indicator when showing error
//                    errorIndicatorColor = MaterialTheme.colorScheme.error // Customize the error indicator color
//                )

            )

            Spacer(modifier = Modifier.height(20.dp))

            Box(modifier = Modifier.padding(60.dp, 30.dp, 60.dp, 0.dp)) {

                Button(
                    onClick = {
                        if (username.value.length > 9) {

                            navController.navigate("OtpPage")
                        } else {
                            Toast.makeText(mContext, "Enter Valid Mobile Number Greater Than 9 Digits", Toast.LENGTH_SHORT).show()

                        }

                    },

                    colors = ButtonDefaults.outlinedButtonColors(colorResource(id = R.color.green_color)),
                    shape = RoundedCornerShape(50.dp),

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Login", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
//            ClickableText(
//                text = AnnotatedString("Forgot password?"), onClick = {
//                    navController.navigate("ForgotPassword")
//                }, style = TextStyle(
//                    fontSize = 14.sp, fontFamily = FontFamily.Default, color = Color.White
//                )
//            )
        }


        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = {
                navController.navigate("Register")
            },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Color.White
            )
        )
    }

}