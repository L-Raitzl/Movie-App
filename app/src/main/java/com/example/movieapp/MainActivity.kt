package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val movie: Movie = Movie()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.movie = movie

        val actionButton: FloatingActionButton = findViewById(R.id.floatingActionButton)
        actionButton.setOnClickListener{ actionOnButton() }
    }

    private fun actionOnButton() {
        Toast.makeText(this, "You just pushed a Button! Nice.",
            Toast.LENGTH_SHORT).show()
    }
}