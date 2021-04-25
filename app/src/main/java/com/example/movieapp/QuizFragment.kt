package com.example.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentQuizBinding
import com.example.movieapp.models.QuestionCatalogue


class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding
    private val questions = QuestionCatalogue().defaultQuestions    // get a list of questions for the game
    private var score = 0                                           // save the user's score
    private var index = 0                                           // index for question data to show

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false)

        index = 0
        score = 0

        binding.index = index
        binding.questionsCount = questions.size
        binding.question = questions[index]

        binding.btnNext.setOnClickListener {
            nextQuestion()
        }

        return binding.root
    }

    private fun nextQuestion(){
        val answerID = binding.answerBox.checkedRadioButtonId
        // Get correct Answer
        val correctAnswer = questions[index].answers
                .stream()
                .filter { answer -> answer.isCorrectAnswer }
                .findFirst().get().answerText

        // No answer selected
        if (answerID == -1) {
            // Show correct answer:
            Toast.makeText(
                    context,
                    "Correct Answer:\n$correctAnswer",
                    Toast.LENGTH_LONG
            ).show()
        } else {
            val selectedRadioButton: RadioButton = binding.answerBox.findViewById(answerID)
            val selectedAnswer = selectedRadioButton.text

            if (selectedAnswer == correctAnswer) {
                score += 1
            }
            // Uncheck Radio Button
            selectedRadioButton.isChecked = false
        }

        index += 1
        if (index < questions.size) {
            binding.index = index
            binding.question = questions[index]
        } else {
            findNavController().navigate(
                    QuizFragmentDirections.actionQuizFragmentToQuizEndFragment(
                            score, questions.size
                    )
            )
        }

    }
}