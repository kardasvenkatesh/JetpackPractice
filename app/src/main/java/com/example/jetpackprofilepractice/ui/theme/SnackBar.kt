package com.example.jetpackprofilepractice.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun SnackBar() {

    // State to control the visibility of the snack bar
    val snackBarVisible = remember { mutableStateOf(false) }

    // Function to show the snack bar
    fun showSnackBar() {
        snackBarVisible.value = true
    }

    // Function to hide the snack bar
    fun hideSnackBar() {
        snackBarVisible.value = false
    }


}