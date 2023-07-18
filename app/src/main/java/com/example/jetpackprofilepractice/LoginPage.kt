package com.example.jetpackprofilepractice

import android.provider.CalendarContract.Colors
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackprofilepractice.ui.theme.SnackBar
import com.example.jetpackprofilepractice.ui.theme.md_theme_dark_background
import com.example.navigationdrawercomposeexample.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.dark_grey)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            val username = remember { mutableStateOf("") }
            val password = remember { mutableStateOf("") }
            val mContext = LocalContext.current
            var showError by remember { mutableStateOf(false) }
            var showPassword by remember { mutableStateOf(value = false) }
            var passwordVisible by rememberSaveable { mutableStateOf(false) }

            val (snackbarVisibleState, setSnackBarState) = remember { mutableStateOf(false) }

            val snackBarVisible = remember { mutableStateOf(false) }

            // Function to show the snack bar
            fun showSnackBar() {
                snackBarVisible.value = true
            }

            // Function to hide the snack bar
            fun hideSnackBar() {
                snackBarVisible.value = false
            }


            var fontname = FontFamily(Font(R.font.volkarne_bold))
            val myColor = R.color.text_field_bg

            Spacer(modifier = Modifier.height(0.dp))
            Text(
                text = "Welcome to Locaticus",
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


            TextField(value = username.value,
                onValueChange = {
                    username.value = it
                    showError = false
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email, contentDescription = "Email Icon"
                    )
                },

                modifier = Modifier
                    .background(
                        color = Color(R.color.dark_grey_light), RoundedCornerShape(percent = 50)
                    )
                    .width(350.dp)
                    .height(60.dp),
                textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
                label = { Text("Enter Username") },

                isError = showError,
                visualTransformation = if (showError) VisualTransformation.None else VisualTransformation.None, // Optional: Hides input text when showing error
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent, // Optional: Hide the focus indicator when showing error
                    unfocusedIndicatorColor = Color.Transparent, // Optional: Hide the focus indicator when showing error
                    errorIndicatorColor = MaterialTheme.colorScheme.error // Customize the error indicator color
                )

            )

            Spacer(modifier = Modifier.height(20.dp))


            TextField(

                value = password.value,
                onValueChange = { password.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock, contentDescription = "Email Icon"
                    )
                },
                modifier = Modifier
                    .background(
                        color = Color(R.color.text_field_bg), RoundedCornerShape(percent = 10)
                    )
                    .width(350.dp)
                    .height(60.dp),
                textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
                label = { Text("Enter Password") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible) Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    // Please provide localized description for accessibility services
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                }

            )


            Spacer(modifier = Modifier.height(40.dp))

            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {

                Button(
                    onClick = {


                        if (username.value.isEmpty() and password.value.isNotEmpty()) {
                            move()
                        }

                        if (username.value.isNotEmpty() and password.value.isEmpty()) {

                            Toast.makeText(mContext, "Password is Empty", Toast.LENGTH_SHORT).show()
                        }

                        if (username.value.isEmpty() and password.value.isEmpty()) {
                            Toast.makeText(
                                mContext, "Please enter Username and Password", Toast.LENGTH_SHORT
                            ).show()
                        }

                        if (username.value.isNotEmpty() and password.value.isNotEmpty()) {
                            Toast.makeText(mContext, "Login Successful", Toast.LENGTH_SHORT).show()
                            navController.navigate("HomeActivity")
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
            ClickableText(
                text = AnnotatedString("Forgot password?"), onClick = {
                    navController.navigate("ForgotPassword")
                }, style = TextStyle(
                    fontSize = 14.sp, fontFamily = FontFamily.Default, color = Color.White
                )
            )
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


@Preview
@Composable
fun MyLogScreenPreview() {
    val navController = rememberNavController()

    MaterialTheme {
        Surface {
            LoginPage(navController)
        }
    }
}


fun move() {

   Log.d("Username","empty username")

}

