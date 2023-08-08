package com.kardas.jetpackprofilepractice.test

object RegistrationUtil {

    private val exitstingUsers = listOf("kardas", "venkatesh")

    fun validRegistrationInput(
        username: String, password: String, confirmPassword: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty()) {
            return false
        }

        if (username in exitstingUsers) {
            return false
        }

        if (password != confirmPassword) {
            return false
        }

        if (password.count { it.isDigit() } < 2) {
            return false
        }

        return true
    }


}