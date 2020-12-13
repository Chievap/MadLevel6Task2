package com.example.madlevel6task1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.madlevel6task1.databinding.FragmentMoviesBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieDetailsFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeMovie()
    }

    private fun observeMovie() {
        sharedViewModel.selectedMovie.observe(viewLifecycleOwner) { movie ->
            Glide.with(this).load(movie.getBackdropImageUrl())
                .into(fragmentMoviesBinding.ivBackdropImage)
            Glide.with(this).load(movie.getPosterImageUrl())
                .into(fragmentMoviesBinding.ivPosterImage)
            fragmentMoviesBinding.tvMovieTitle.text = movie.title
            fragmentMoviesBinding.tvMovieDate.text = movie.releaseDate
            fragmentMoviesBinding.tvStarRating.text = movie.rating.toString()
            fragmentMoviesBinding.tvOverviewText.text = movie.overview
        }
    }
}