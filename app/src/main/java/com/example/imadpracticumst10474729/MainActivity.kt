package com.example.practicetravelapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.imadpracticumst10474729.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainMenubutton = findViewById<Button>(R.id.btnStart)
        val exitButton = findViewById<Button>(R.id.btnExit)
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val nameText = findViewById<TextView>(R.id.nameText)

        mainMenubutton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finish()
        }
    }
}