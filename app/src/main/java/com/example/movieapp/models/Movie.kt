package com.example.movieapp.models

import com.example.movieapp.R
import java.util.*

data class Movie (
    var title: String = "",
    var story: String = ""
) {
    val id: UUID = UUID.randomUUID()
    var rating: Float = 0.0f
        set(value) {
            if(value in 0.0..5.0) field = value
            else throw IllegalArgumentException("Rating value must be between 0 and 5")
        }
    var imageId: Int = R.drawable.posterwhiplash
    var genre: List<String>? = null
    var director: MutableList<String> = mutableListOf()
    var actors: MutableList<String> = mutableListOf()
}