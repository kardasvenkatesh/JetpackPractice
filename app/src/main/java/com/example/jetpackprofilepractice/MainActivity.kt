package com.example.jetpackprofilepractice

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackexample.ui.theme.JetpackExampleTheme
import com.example.navigationdrawercomposeexample.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackExampleTheme() {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = colorResource(R.color.bg_color)
                ) {
                    ScreenMain()
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
            modifier = Modifier.fillMaxSize().padding(20.dp),
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



