package com.example.madlevel6task1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.madlevel6task1.R
import com.example.madlevel6task1.databinding.FragmentMovieDetailsBinding
import com.example.madlevel6task1.databinding.FragmentMoviesBinding
import com.example.madlevel6task2.entity.Movie
import com.example.madlevel6task2.entity.MovieLanguage

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MoviesFragment : Fragment() {
    private val viewModel: MovieViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var fragmentMoviesBinding: FragmentMovieDetailsBinding

    private val movies = arrayListOf<Movie>()
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMoviesBinding = FragmentMovieDetailsBinding.inflate(layoutInflater)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moviesAdapter = MoviesAdapter(movies, this::onMovieClick)
        fragmentMoviesBinding.rvMovies.layoutManager =
            GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
        fragmentMoviesBinding.rvMovies.adapter = moviesAdapter

        fragmentMoviesBinding.btnSubmit.setOnClickListener {

            val movieLanguage = MovieLanguage.EnglishUS
            val movieYear = fragmentMoviesBinding.etYear.text.toString()

            if (movieYear.isNotBlank()) {
                viewModel.getMovies(movieLanguage.language, movieYear.toInt())
            }
        }

        observeMovies()
    }

    private fun observeMovies() {
        viewModel.movies.observe(viewLifecycleOwner, {
            this.movies.clear()
            this.movies.addAll(it.results)
            this.moviesAdapter.notifyDataSetChanged()
        })
    }

    private fun onMovieClick(movie: Movie) {
        sharedViewModel.select(movie)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}