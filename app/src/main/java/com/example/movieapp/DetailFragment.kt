package com.example.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.movieapp.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val args = DetailFragmentArgs.fromBundle(requireArguments())
        val movies = MovieStore().defaultMovies

        when(val movieEntry = movies.getOrNull(args.movieIndex)){
            null -> {
                Toast.makeText(requireContext(), "Not able to load data.", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }
            else -> binding.movie = movieEntry
        }

        binding.addToFavorites.setOnClickListener {
            Toast.makeText(requireContext(), "Saved to favorites.", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}