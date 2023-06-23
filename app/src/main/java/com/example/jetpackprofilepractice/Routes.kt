package com.example.jetpackprofilepractice

sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object Register : Routes("Register")
    object ForgotPassword : Routes("ForgotPassword")
    object MyHomePage : Routes("HomeActivity")
    object ProductDetails : Routes("ProductDetail")
    object CartPage : Routes("CartPage")
}