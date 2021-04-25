package com.example.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.movieapp.databinding.FragmentQuizEndBinding


class QuizEndFragment : Fragment() {
    private lateinit var binding: FragmentQuizEndBinding
    private val args: QuizEndFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz_end, container, false)

        // get score from navigation arguments
        val score = args.score
        val numberQuestions = args.numberQuestions

        // show score
        val summary = "$score/$numberQuestions"
        binding.textView7.text = summary

        // on "RESTART" button pressed
        binding.btnRestart.setOnClickListener {
            restartQuiz()
        }
        return binding.root
    }

    private fun restartQuiz() {
        activity?.onBackPressed()
    }
}