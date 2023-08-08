package com.kardas.jetpackprofilepractice.test

object LoginUtil {

    private val existingLoginuser = listOf("kardas","venkatesh","shiva")
    private val existingLoginuserForPassword = listOf("Kardas@123","Venkat@123","Shiva@123")

    fun validateLoginInputs(username: String, password: String): Boolean {

        if (username.isNotEmpty() || password.isNotEmpty()) {
            return true
        }

        if (username in existingLoginuser) {
            return true
        }

        if (password in existingLoginuserForPassword) {
            return true
        }

        return false

    }
}