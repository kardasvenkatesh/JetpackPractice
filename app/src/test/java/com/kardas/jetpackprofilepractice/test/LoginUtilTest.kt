package com.kardas.jetpackprofilepractice.test

import org.junit.Assert
import org.junit.Test

class LoginUtilTest {

    @Test
    fun empty_user_name(){

        val result = LoginUtil.validateLoginInputs("","Kardas@123")

        Assert.assertTrue(result);
    }

    @Test
    fun empty_password(){
        val result = LoginUtil.validateLoginInputs("kardas","")

        Assert.assertTrue(result);
    }

    @Test
    fun details_not_exists(){
        val result = LoginUtil.validateLoginInputs("mahesh","mahesh@123")

        Assert.assertTrue(result);
    }

    @Test
    fun details_exists(){
        val result = LoginUtil.validateLoginInputs("kardas","Kardas@123")

        Assert.assertTrue(result);
    }


}