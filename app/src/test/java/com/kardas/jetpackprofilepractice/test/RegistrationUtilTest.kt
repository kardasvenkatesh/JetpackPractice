package com.kardas.jetpackprofilepractice.test

import org.junit.Assert.*
import org.junit.Test

class RegistrationUtilTest{

    @Test
    fun `empty username returns false`(){
        val result = RegistrationUtil.validRegistrationInput(
            "","123","123"
        )

        assertFalse(result);
    }

    @Test
    fun `valid username name and correctly repeated password returns true`(){
        val result = RegistrationUtil.validRegistrationInput(
            "kardasven","123","123"
        )

        assertTrue(result);
    }

    @Test
    fun `username already exits returns false`(){
        val result = RegistrationUtil.validRegistrationInput(
            "kardas","123","123"
        )

        assertFalse(result);
    }

    @Test
    fun `incorrectly confirmed password returns false`(){
        val result = RegistrationUtil.validRegistrationInput(
            "kardas","123","1234"
        )

        assertFalse(result);
    }


    @Test
    fun `empty password returns false`(){
        val result = RegistrationUtil.validRegistrationInput(
            "kardas","",""
        )

        assertFalse(result);
    }


    @Test
    fun `less than 2 digits password returns false`(){
        val result = RegistrationUtil.validRegistrationInput(
            "kardas","abcd1","abcd2"
        )

        assertFalse(result);
    }
}