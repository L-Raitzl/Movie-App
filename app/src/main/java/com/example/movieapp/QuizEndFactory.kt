package com.example.movieapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.viewmodels.QuizEndViewModel

class QuizEndFactory(
        private val application: Application,
        private val score: Int,
        private val numberOfQuestions: Int
) :
        ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizEndViewModel::class.java)) {
            return QuizEndViewModel(application, score, numberOfQuestions) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
