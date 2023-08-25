package com.kardas.jetpackprofilepractice

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ScreenMain() {

    val navController = rememberNavController()
    var counter: String? = "1"

    NavHost(navController = navController, startDestination = Routes.Login.route) {

        Log.d("testing", "testing")

        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }

        composable(Routes.Register.route) {
            SignUp(navController = navController)
        }

        composable(Routes.ForgotPassword.route) {
            ForgotPassword(navController = navController)
        }


        composable(Routes.MyHomePage.route) {
            MyHomePage(navController = navController)
        }

        composable(Routes.CartPage.route) {
            CartPage(navController = navController, navigateBack = { navController.popBackStack() })

        }

        composable(Routes.CheckoutPage.route) {
            CheckoutScreen(
                navController = navController,
                navigateBack = { navController.popBackStack() })

        }

        composable(Routes.SuccessPage.route) {
            SuccessScreen(
                navController = navController,
                navigateBack = { navController.popBackStack() })

        }

        composable(Routes.OtpPage.route) {
            OtpScreen(
                navController = navController,
                navigateBack = { navController.popBackStack() })

        }


//        composable(Routes.ProductDetail.route) {
//            ProductDetail(navController = navController, counter!!)
//        }

//        composable(
//            "second_screen?title={title}", arguments = listOf(navArgument("title") {
//                type = NavType.StringType
//                defaultValue = "Second Screen"
//            })
//        ) {
//
//            ProductDetail(navController = navController, it.arguments?.getString("title"))
//        }

//        composable(
//            "second_screen?title= {title}", arguments = listOf(navArgument("title") {
//
//                type = NavType.StringType
//                defaultValue = "Second Screen"
//            })
//        ) {
//
//            ProductDetail(navController = navController, it.arguments?.getString("title"))
//        }

        composable(Routes.ProductDetails.route + "/{title}?{price}?{category}?{description}?{id}?{image}") { navBackStack ->

            val title = navBackStack.arguments?.getString("title")
            val price = navBackStack.arguments?.getString("price")
            val category = navBackStack.arguments?.getString("category")
            val description = navBackStack.arguments?.getString("description")
            val id = navBackStack.arguments?.getString("id")
            val image = navBackStack.arguments?.getString("image")



            Log.d(
                "imggg",
                "," + title + ",  " + price + "," + category + "," + image + ",,,,,,,,," + description + "," + id
            )

            if (category != null) {
                if (price != null) {
                    if (image != null) {
                        if (description != null) {
                            Log.d("imgesneww", image)

                            ProductDetail(
                                id = id!!.toInt(),
                                description = description,
                                title = title,
                                price = price,
                                category = category,
                                navController = navController,
                                image = image

                            )

                            Log.d("magessss", image.toString())

                        }
                    }
                }
            }
//            ProductDetail(image = image)
        }

//        composable(Routes.ProductDetails.route + "/{title}",
//            arguments = listOf(
//                navArgument("title") {
//                    type = NavType.LongType
//                },
////                navArgument("category") {
////                    type = NavType.StringType
////                    nullable = true
////                }
//            ),
//        ){backStackEntry ->
//            val arguments = requireNotNull(backStackEntry.arguments)
//            val title = arguments.getString("name")
//            val category = arguments.getString("category")
//            ProductDetail(title)
//        }
        //        { navBackStack ->
//
//            val counter = navBackStack.arguments?.getString("name")
//            var category = navBackStack.arguments?.getString("category")
//
//
//
//            Log.d("imggg", "," + counter + ",  " + category)
//
//            ProductDetail(counter = counter, category = category)
////            ProductDetail(image = image)
//        }

    }


}