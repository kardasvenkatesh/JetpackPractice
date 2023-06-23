package com.example.jetpackprofilepractice.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.UPDATE_BOOK_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateProductTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar (

        title = {
            Text(
                text = "My Cart", color = White
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Black),

        navigationIcon = {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    tint = White,
                    contentDescription = null,
                )
            }
        }
    )
}