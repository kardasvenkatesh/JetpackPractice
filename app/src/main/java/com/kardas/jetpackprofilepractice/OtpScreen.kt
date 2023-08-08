package com.kardas.jetpackprofilepractice

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navigationdrawercomposeexample.R

@Composable
fun OtpScreen(navController: NavController, navigateBack: () -> Unit) {

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


            val otp1 = remember { mutableStateOf("") }
            val otp2 = remember { mutableStateOf("") }
            val otp3 = remember { mutableStateOf("") }
            val otp4 = remember { mutableStateOf("") }

            val focusRequester1 = remember { FocusRequester() }
            val focusRequester2 = remember { FocusRequester() }
            val focusRequester3 = remember { FocusRequester() }
            val focusRequester4 = remember { FocusRequester() }

            val coroutineScope = rememberCoroutineScope()

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


            Text(
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Enter the OTP received on your mobile",

                style = TextStyle(fontSize = 16.sp, color = Color.White),

                )

//            LaunchedEffect(otp1) {
//                if (otp1.value.length == 1) {
//                    delay(100) // Delay to allow focus to be set properly
//                    focusRequester2.requestFocus()
//                }
//            }



            Row() {

                val focusRequester2 = remember { FocusRequester() }


                TextField(
                    value = otp1.value,
                    singleLine = true,
//                onValueChange = {
//                    username.value = it.isDigitsOnly().toString()
////                    showError = false
//                },

                    onValueChange = { newValue ->
                        otp1.value = newValue.filter { it.isDigit() }.take(1)
                    },

                    modifier = Modifier
                        .padding(start = 5.dp)
                        .background(
                            color = Color(R.color.dark_grey_light), RoundedCornerShape(percent = 50)
                        )
                        .width(60.dp)
                        .height(60.dp)
                        .wrapContentHeight()
                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp)),
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)


                )


                TextField(
                    value = otp2.value,
                    singleLine = true,
//                onValueChange = {
//                    username.value = it.isDigitsOnly().toString()
////                    showError = false
//                },

                    onValueChange = { newValue ->
                        otp2.value = newValue.filter { it.isDigit() }
                    },

                    modifier = Modifier
                        .padding(start = 5.dp)
                        .background(
                            color = Color(R.color.dark_grey_light), RoundedCornerShape(percent = 50)
                        )
                        .width(60.dp)
                        .height(60.dp)
                        .wrapContentHeight()
                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp)),
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)


                )

                TextField(
                    value = otp3.value,
                    singleLine = true,
//                onValueChange = {
//                    username.value = it.isDigitsOnly().toString()
////                    showError = false
//                },

                    onValueChange = { newValue ->
                        otp3.value = newValue.filter { it.isDigit() }
                    },

                    modifier = Modifier
                        .padding(start = 5.dp)
                        .background(
                            color = Color(R.color.dark_grey_light), RoundedCornerShape(percent = 50)
                        )
                        .width(60.dp)
                        .height(60.dp)
                        .wrapContentHeight()
                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp)),
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

//                isError = showError,
//                visualTransformation = if (showError) VisualTransformation.None else VisualTransformation.None, // Optional: Hides input text when showing error
//                colors = TextFieldDefaults.textFieldColors(
//                    focusedIndicatorColor = Color.Transparent, // Optional: Hide the focus indicator when showing error
//                    unfocusedIndicatorColor = Color.Transparent, // Optional: Hide the focus indicator when showing error
//                    errorIndicatorColor = MaterialTheme.colorScheme.error // Customize the error indicator color
//                )

                )

                TextField(
                    value = otp4.value,
                    singleLine = true,
//                onValueChange = {
//                    username.value = it.isDigitsOnly().toString()
////                    showError = false
//                },

                    onValueChange = { newValue ->
                        otp4.value = newValue.filter { it.isDigit() }
                    },

                    modifier = Modifier
                        .padding(start = 5.dp)
                        .background(
                            color = Color(R.color.dark_grey_light), RoundedCornerShape(percent = 50)
                        )
                        .width(60.dp)
                        .height(60.dp)
                        .wrapContentHeight()
                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp)),
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

//                isError = showError,
//                visualTransformation = if (showError) VisualTransformation.None else VisualTransformation.None, // Optional: Hides input text when showing error
//                colors = TextFieldDefaults.textFieldColors(
//                    focusedIndicatorColor = Color.Transparent, // Optional: Hide the focus indicator when showing error
//                    unfocusedIndicatorColor = Color.Transparent, // Optional: Hide the focus indicator when showing error
//                    errorIndicatorColor = MaterialTheme.colorScheme.error // Customize the error indicator color
//                )

                )


            }


            Spacer(modifier = Modifier.height(20.dp))

            Box(modifier = Modifier.padding(60.dp, 30.dp, 60.dp, 0.dp)) {

                Button(
                    onClick = {
                        if (otp1.value.isEmpty()) {
                            Toast.makeText(mContext, "Otp is Empty", Toast.LENGTH_SHORT).show()

                        } else {
                            navController.navigate("HomeActivity")
                        }

                    },

                    colors = ButtonDefaults.outlinedButtonColors(colorResource(id = R.color.green_color)),
                    shape = RoundedCornerShape(50.dp),

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Validate OTP", color = Color.White)
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

    }
}