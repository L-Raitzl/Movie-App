package com.example.movieapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.models.MovieStore


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        setHasOptionsMenu(true) // enable the options menu in the action bar

        val adapter = MovieListAdapter()    // instantiate a new MovieListAdapter for recyclerView
        binding.movieList.adapter = adapter // assign adapter to the recyclerView

        subscribeUI(adapter)

        return binding.root
    }

    private fun subscribeUI(adapter: MovieListAdapter){
        val movieList = MovieStore()
        adapter.submitList(movieList.defaultMovies) // submit the statically generated movielist to the recyclerView
    }

    /*
    private fun navigateToDetail(movieIdx: Int = 0){
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(movieIdx))
    } */

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
