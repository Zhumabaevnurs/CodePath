package com.example.flixsterplus2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RatingBar
import android.widget.TextView


private const val TAG = "DetailActivity"
class DetailActivity : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var tvOverride: TextView
    private lateinit var ratingBar: RatingBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)
        tvTitle = findViewById(R.id.tvTitle)
        tvOverride = findViewById(R.id.tvOverview)
        ratingBar = findViewById(R.id.ratingBar)

        val movie = intent.getParcelableExtra<Movie>(MOVIE_DESC) as Movie
        Log.i(TAG, "Movie is $movie")
        tvTitle.text = movie.title
        tvOverride.text = movie.overview

        //get rating of movie
        ratingBar.rating = movie.voteAverage.toFloat()
    }
}