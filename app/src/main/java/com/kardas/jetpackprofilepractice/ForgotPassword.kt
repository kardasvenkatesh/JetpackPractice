package com.kardas.jetpackprofilepractice

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigationdrawercomposeexample.R

@Composable
fun ForgotPassword(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.bg_color)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val username = remember { mutableStateOf(TextFieldValue()) }
            val password = remember { mutableStateOf(TextFieldValue()) }


            var fontname = FontFamily(Font(R.font.volkarne_bold))
            val myColor = R.color.text_field_bg

            Spacer(modifier = Modifier.height(0.dp))
            Text(
                text = "Forgot Password?",
                style = TextStyle(fontSize = 30.sp, color = Color.White, fontFamily = fontname)
            )

            Spacer(modifier = Modifier.height(50.dp))

            Image(
                painterResource(R.drawable.location),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(50.dp))


            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email, contentDescription = "Email Icon"
                    )
                },
                modifier = Modifier
                    .background(
                        color = Color(R.color.text_field_bg), RoundedCornerShape(percent = 50)
                    )
                    .width(350.dp)
                    .height(60.dp),
                textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
                label = { Text("Enter email/mobile") },

                )

            Spacer(modifier = Modifier.height(20.dp))




            Spacer(modifier = Modifier.height(40.dp))
            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.outlinedButtonColors(colorResource(id = R.color.green_color)),
                    shape = RoundedCornerShape(50.dp),

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Submit", color = Color.White)
                }
            }

        }


    }


}

@Preview
@Composable
fun MyForgotScreenPreview() {
    val navController = rememberNavController()

    MaterialTheme {
        Surface {
            ForgotPassword(navController)
        }
    }
}
