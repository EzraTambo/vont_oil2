package com.example.vontoil2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity




class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



    }



    fun Signup(view: View) {
        val intent = Intent(this, register::class.java).apply{

        }
        startActivity(intent)
    }





}