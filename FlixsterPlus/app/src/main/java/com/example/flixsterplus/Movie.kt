package com.example.flixsterplus

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.json.JSONArray

@Parcelize
class Movie (
    private val subMovie : String,
    val movieID : Int,
    val title : String,
    val overView : String,
): Parcelable {

    @IgnoredOnParcel
    val posterURL = "https://image.tmdb.org/t/p/w500/$subMovie"

    companion object {

        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {

            val movies = mutableListOf<Movie>()

            for (i in 0 until movieJsonArray.length()) {

                val movieJson = movieJsonArray.getJSONObject(i)

                movies.add(

                    Movie(
                        movieJson.getString("poster_path"),
                        movieJson.getInt("id"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")



                    )

                )

            }

            return movies
        }

    }
}