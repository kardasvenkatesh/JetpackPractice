package com.kardas.jetpackprofilepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.navigationdrawercomposeexample.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kardas.jetpackexample.ui.theme.JetpackExampleTheme
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCenter.start(
            application, "a14af8202a927fa6281a0381108a571d08fd81fe",
            Analytics::class.java, Crashes::class.java
        )

        setContent {
            JetpackExampleTheme() {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = colorResource(R.color.bg_color)
                ) {

                    SetStatusBarColor {
                        // Your app content goes here
                        ScreenMain()
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackExampleTheme {
        ScreenMain()
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
public fun SnackbarExample() {
    Column {
        val (visible, setVisible) = remember { mutableStateOf(false) }

        Button(onClick = { setVisible(!visible) }, modifier = Modifier.padding(20.dp)) {
            if (visible) {
                Text("Hide Snackbar")
            } else {
                Text("Show Snackbar")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
        ){
            Row(modifier = Modifier.align(Alignment.BottomEnd)){
                if (visible) {
                    Snackbar(
                        action = {
                            Button(onClick = {}) {
                                Text("Action")
                            }
                        },
                        modifier = Modifier.padding(8.dp)
                    ) { Text(text = "Jetpack Compose Snackbar Example!") }
                }
            }
        }
    }
}


@Composable
fun SetStatusBarColor(content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()

    // Change the status bar color to the desired color
    systemUiController.setStatusBarColor(
        color = Color.Black // Replace with your desired color
    )
//        .

    content()
}


