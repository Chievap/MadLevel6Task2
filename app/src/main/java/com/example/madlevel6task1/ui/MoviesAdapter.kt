package com.example.madlevel6task1.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.madlevel6task1.databinding.ItemPosterBinding
import com.example.madlevel6task2.entity.Movie

class MoviesAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val itemMoviePosterBinding =
            ItemPosterBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(itemMoviePosterBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])

    override fun getItemCount(): Int = movies.size


    inner class ViewHolder(private val itemMovie: ItemPosterBinding) :
        RecyclerView.ViewHolder(itemMovie.root) {

        init {
            itemMovie.root.setOnClickListener {
                onClick(movies[adapterPosition])
            }
        }

        fun bind(movie: Movie) {
            val position = (adapterPosition + 1).toString() + "."
            itemMovie.tvMoviePosition.text = position
            Glide.with(context).load(movie.getPosterImageUrl()).into(itemMovie.ivRvPoster)
        }
    }
}
