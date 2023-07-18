package com.example.jetpackprofilepractice.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.jetpackprofilepractice.MyTopAppBar
import com.example.navigationdrawercomposeexample.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsTopBar() {
    TopAppBar (
        title = { Text("My cart", style = TextStyle(fontSize = 20.sp, color = Color.White)) },
        actions = {
            // search icon
//            TopAppBarActionButton(
//
//                imageVector = Icons.Outlined.Search, description = "Search"
//            ) {
//                Toast.makeText(contextForToast, "Search Click", Toast.LENGTH_SHORT).show()
//            }

            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    Icons.Filled.Search, "contentDescription", tint = Color.White
                )
            }

            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    Icons.Filled.Settings, "contentDescription", tint = Color.White
                )
            }


//            // lock icon
//            TopAppBarActionButton(
//                imageVector = Icons.Outlined.Lock, description = "Lock"
//            ) {
//                Toast.makeText(contextForToast, "Lock Click", Toast.LENGTH_SHORT).show()
//            }
        },
        modifier = Modifier.background(color = colorResource(id = R.color.dark_grey)),
        colors = TopAppBarDefaults.smallTopAppBarColors(colorResource(id = R.color.dark_grey))
    )

}