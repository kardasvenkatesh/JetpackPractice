package com.example.jetpackprofilepractice

import android.content.Context
import androidx.compose.runtime.Composable
import com.google.firebase.FirebaseApp

object Firebase {

    @Composable
    fun initialize(context: Context) {
        FirebaseApp.initializeApp(context)
        // Other Firebase initialization code if needed
    }

    @Composable
    fun dispose() {
        // Dispose Firebase resources if necessary
    }
}