package com.example.jetpackprofilepractice

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackexample.ui.theme.JetpackExampleTheme
import com.example.navigationdrawercomposeexample.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUp(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = { },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = colorResource(id = R.color.bg_color)
            )
        )
    }
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }


    fun validate(text: String) {
        isError = false
    }

    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.bg_color))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val name = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val mobile = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val confirmpassword = remember { mutableStateOf("") }
        var isError by rememberSaveable { mutableStateOf(false) }

        val mContext = LocalContext.current

        var fontname = FontFamily(Font(R.font.volkarne_bold))

        Text(
            text = "Register Here",
            style = TextStyle(fontSize = 25.sp, color = Color.White, fontFamily = fontname)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Image(
            painterResource(R.drawable.location),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(70.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            trailingIcon = {
                if (isError)
                    Icon(Icons.Filled.Email,"error", tint = MaterialTheme.colorScheme.error)
            },

            singleLine = true,
            isError = isError,
            keyboardActions = KeyboardActions { validate(text) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = "Email Icon"
                )
            },
            modifier = Modifier
                .background(
                    color = Color(R.color.text_field_bg), RoundedCornerShape(percent = 50)
                )
                .width(350.dp)
                .height(60.dp),
            textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
            label = { Text("Enter Name") },

        )

        if (isError) {
            Text(
                text = "Error message",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = email.value,
            onValueChange = { email.value = it },
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
            label = { Text("Enter Email") },
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = mobile.value,
            onValueChange = { mobile.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Phone, contentDescription = "Email Icon"
                )
            },
            modifier = Modifier
                .background(
                    color = Color(R.color.text_field_bg), RoundedCornerShape(percent = 50)
                )
                .width(350.dp)
                .height(60.dp),
            textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
            label = { Text("Enter Mobile Number") },
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
                    color = Color(R.color.text_field_bg), RoundedCornerShape(percent = 50)
                )
                .width(350.dp)
                .height(60.dp),
            textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
            label = { Text("Enter Password") },

            singleLine = true,
            isError = isError,

            trailingIcon = {
                if (isError)
                    Icon(Icons.Filled.Email,"error", tint = MaterialTheme.colorScheme.error)
            }
        )

        Spacer(modifier = Modifier.height(20.dp))


        TextField(
            value = confirmpassword.value,
            onValueChange = { confirmpassword.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock, contentDescription = "Email Icon"
                )
            },
            modifier = Modifier
                .background(
                    color = Color(R.color.text_field_bg), RoundedCornerShape(percent = 50)
                )
                .width(350.dp)
                .height(60.dp),
            textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
            label = { Text("Enter Confirm Password") },
        )

        Spacer(modifier = Modifier.height(40.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {

                    if (name.value.isNotEmpty()) {
                        if (email.value.isNotEmpty()) {
                            if (mobile.value.isNotEmpty()) {
                                if (password.value.isNotEmpty()) {
                                    if (confirmpassword.value.isNotEmpty()) {
                                        Toast.makeText(
                                            mContext, "Registration Successful", Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        Toast.makeText(
                                            mContext, "Enter Confirm Password", Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                } else {
                                    Toast.makeText(
                                        mContext, "Enter Password", Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } else {
                                Toast.makeText(
                                    mContext, "Enter Mobile", Toast.LENGTH_SHORT
                                ).show()
                            }

                        } else {
                            Toast.makeText(
                                mContext, "Enter Email", Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            mContext, "Enter Name", Toast.LENGTH_SHORT
                        ).show()
                    }



                    if (mobile.value.isEmpty() and password.value.isEmpty()) {
                        Toast.makeText(
                            mContext, "Please enter Username and Password", Toast.LENGTH_SHORT
                        ).show()
                    }

                    if (password.value.isNotEmpty() and password.value.isNotEmpty()) {
                        Toast.makeText(mContext, "Login Successful", Toast.LENGTH_SHORT).show()
                    }

                    if (confirmpassword.value.isNotEmpty() and password.value.isNotEmpty()) {
                        Toast.makeText(mContext, "Login Successful", Toast.LENGTH_SHORT).show()
                    }

                },
                colors = ButtonDefaults.outlinedButtonColors(colorResource(id = R.color.green_color)),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Register", color = Color.White)
            }
        }


    }

//    Scaffold(
//        modifier = Modifier
//            .background(colorResource(id = R.color.bg_color))
//            .fillMaxSize()
//    ) {
//
//
//
//    }


}

@Preview
@Composable
fun MyScreenPreview() {
    val navController = rememberNavController()

    MaterialTheme {
        Surface {
            SignUp(navController)
        }
    }
}
