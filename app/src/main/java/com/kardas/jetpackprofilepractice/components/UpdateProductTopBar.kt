package com.kardas.jetpackprofilepractice.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateProductTopBar(title: String,
    navigateBack: () -> Unit
) {
    TopAppBar (

        title = {
            Text(
                text = title, color = White
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