package com.example.flixsterplus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter (private val context: Context, private val movies: List<Movie>):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)

    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val m_poster = itemView.findViewById<ImageView>(R.id.movie_poster)
        private val m_title = itemView.findViewById<TextView>(R.id.movie_title)
        private val m_overview = itemView. findViewById<TextView>(R.id.movie_overview)


        fun bind(movie: Movie){
            m_title.text = movie.title
            m_overview.text= movie.overView
            Glide.with(context).load(movie.posterURL).into(m_poster)
        }
    }
}