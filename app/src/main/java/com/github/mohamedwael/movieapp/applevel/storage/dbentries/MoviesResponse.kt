package com.github.mohamedwael.movieapp.applevel.storage.dbentries

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.mohamedwael.core.domain.Movie
import com.github.mohamedwael.core.domain.Movies
import com.google.gson.annotations.SerializedName

class MoviesResponse : ArrayList<MovieItem>()

@Entity(tableName = "MovieItem")
data class MovieItem(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    @PrimaryKey
    val id: Int? = null
)

fun MoviesResponse.toMovies(): Movies {
    val movies = Movies()
    map { movies.add(it.toMovie()) }
    return movies
}

fun MovieItem.toMovie() = Movie(image, name, description, id)
