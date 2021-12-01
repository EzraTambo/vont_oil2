package com.example.vontoil2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun Register(view: View) {
        val intent = Intent(this, MapsActivity2::class.java).apply{

        }
        startActivity(intent)
    }

    fun login(view: View) {
        val intent = Intent(this, login::class.java).apply{

        }
        startActivity(intent)
    }
}