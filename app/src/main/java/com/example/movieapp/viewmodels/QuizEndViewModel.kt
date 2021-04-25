package com.example.movieapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class QuizEndViewModel(application: Application, score: Int, numberOfQuestions: Int) :
    AndroidViewModel(application) {
    val Score = MutableLiveData<Int>()
    val NumberOfQuestions = MutableLiveData<Int>()

    init { //initialize
        Log.i("QuizEndViewModel", "Final Score is $score")
        Score.value = score
        NumberOfQuestions.value = numberOfQuestions
    }
}
