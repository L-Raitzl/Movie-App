package com.example.movieapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.movies = MovieStore()

        setHasOptionsMenu(true)

        subscribeUI()

        return binding.root
    }

    private fun subscribeUI(){
        binding.movie1Btn.setOnClickListener {
            navigateToDetail(0)
        }

        binding.movie2Btn.setOnClickListener {
            navigateToDetail(1)
        }

        binding.movie3Btn.setOnClickListener {
            navigateToDetail(2)
        }
    }

    private fun navigateToDetail(movieIdx: Int = 0){
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(movieIdx))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
}
