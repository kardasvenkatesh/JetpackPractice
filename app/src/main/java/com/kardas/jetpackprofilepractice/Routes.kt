package com.kardas.jetpackprofilepractice

sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object Register : Routes("Register")
    object ForgotPassword : Routes("ForgotPassword")
    object MyHomePage : Routes("HomeActivity")
    object ProductDetails : Routes("ProductDetail")
    object CartPage : Routes("CartPage")
    object CheckoutPage : Routes("CheckoutPage")

    object SuccessPage : Routes("SuccessPage")
    object OtpPage : Routes("OtpPage")
}