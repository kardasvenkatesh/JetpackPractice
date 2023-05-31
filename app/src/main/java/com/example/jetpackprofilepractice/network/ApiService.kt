package com.example.jetpackprofilepractice.network

import com.example.jetpackprofilepractice.Data.CategoriesItem
import com.example.jetpackprofilepractice.Data.MoviesData
import com.example.jetpackprofilepractice.Data.MoviesDataItem
import com.example.jetpackprofilepractice.Data.ProductsItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

//    @GET("movielist.json")
    @GET("categories")
    suspend fun getAllCategories(): List<CategoriesItem>

    @GET("products")
    suspend fun getAllProducts(): List<ProductsItem>

    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BASIC
                apiService = Retrofit.Builder()

                    .baseUrl("https://api.escuelajs.co/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient.Builder().addInterceptor(logging).build()).build()
                    .create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}