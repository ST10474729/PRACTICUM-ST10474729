package com.example.practicetravelapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imadpracticumst10474729.R

class MainActivity3 : AppCompatActivity() {

    //Declaring the screen elements
    private lateinit var txtShowsItems: TextView // shows the full song List list
    private lateinit var txtFilter: TextView // shows ratings
    private lateinit var btnMainMenu: Button // Button to go back to previous screen
    private lateinit var btnSongItems: Button // Button to show the full song list
    private lateinit var btnRatings: Button // Button to show songs with ratings


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3) // Moved to top

        // Link views after layout is set
        txtShowsItems = findViewById(R.id.txtShowItems)
        txtFilter = findViewById(R.id.txtFilter)
        btnMainMenu = findViewById(R.id.btnMainMenu)
        btnSongItems = findViewById(R.id.btnSongItems)
        btnRatings = findViewById(R.id.btnRatings)

        // Receive data from previous screen
        val items = intent.getStringArrayListExtra("items") ?: arrayListOf()
        val categories = intent.getStringArrayListExtra("categories") ?: arrayListOf()
        val quantities = intent.getStringArrayListExtra("quantities") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        // Show all items
        btnSongItems.setOnClickListener {
            val list = items.indices.joinToString("\n") {
                "${items[it]} (${categories[it]}) - ${quantities[it]}: ${comments[it]}"
            }
            txtShowsItems.text = list.ifBlank { "No Songs added!" }
        }

        // Filter items with quantity >= 2
        btnRatings.setOnClickListener {
            val filtered = items.indices
                .filter { quantities[it].toIntOrNull() ?: 0 >= 1 }
                .joinToString("\n") {
                    "${items[it]} (Qty: ${quantities[it]})"
                }
            txtFilter.text =
                filtered.ifBlank { "Please in Ratings" }
        }

        // Return to main menu
        btnMainMenu.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }
}
