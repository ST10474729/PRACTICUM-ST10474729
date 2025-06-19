package com.example.practicetravelapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imadpracticumst10474729.R

class MainActivity2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.S)

    // These are array lists where we store each packing item's details
    val songs = arrayListOf<String>()       // Stores the names of songs.
    val artistname = arrayListOf<String>()  // Stores the artistName of each song.
    val ratings = arrayListOf<Int>()     // Stores the rating of each song.
    val comments = arrayListOf<String>()    // Stores the comment of each song.

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        // Linking UI elements
        // Input field for the items name (e.g toothbrush)
        val itemInput = findViewById<EditText>(R.id.inputSong)

        // Input field for category (e.g.toiletries)
        val categoryInput = findViewById<EditText>(R.id.nameArtist)

        // Input field for how many of that item
        val quantityInput = findViewById<EditText>(R.id.inputRating)

        // Optional Comment (e,g "Use for hotel only)
        val commentsInput = findViewById<EditText>(R.id.inputComments)

        // Button to add items to list
        val addBtn = findViewById<Button>(R.id.btnAdd)

        // Button to view items on list
        val viewBtn = findViewById<Button>(R.id.btnView)

        //Button to completely exit the app
        val exitBtn = findViewById<Button>(R.id.btnExit)



        // When the user clicks the "Input Item" button, this block of code will
        addBtn.setOnClickListener {

            // Store the user input from each text box into a temporary variable
            val songs = itemInput.text.toString()
            val category = categoryInput.text.toString()
            val quantityText = quantityInput.text.toString()
            val comment = commentsInput.text.toString()

            // Validate input fields
            if (songs.isBlank() || category.isBlank() || quantityText.isBlank() || comment.isBlank()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val quantity = quantityText.toIntOrNull()
            if (quantity == null || quantity <= 0) {
                Toast.makeText(
                    this,
                    "Quantity must be a positive number!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Add data to corresponding lists
            val add = songs.add(songs)
            artistname.add(category)
            ratings.add(quantity)
            comments.add(comment)

            Toast.makeText(this, "Item added successfully!", Toast.LENGTH_SHORT).show()

            // Clear input fields
            itemInput.text.clear()
            categoryInput.text.clear()
            quantityInput.text.clear()
            commentsInput.text.clear()

        }


        // "Display" button click listener
        viewBtn.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)

            // Convert quantities from Int to String
            val quantityStrings = ArrayList(ratings.map { it.toString() })

            // Attach all lists as extras
            intent.putStringArrayListExtra("items", songs)
            intent.putStringArrayListExtra("categories", artistname)
            intent.putStringArrayListExtra("quantities", quantityStrings)
            intent.putStringArrayListExtra("comments", comments)

            // Start the display activity
            startActivity(intent)
        }
    }

}

private fun String.add(string: String) {
    val todo = TODO("Not yet implemented")
}
