package com.github.mohamedwael.movieapp.applevel.network

import com.github.mohamedwael.movieapp.applevel.MOVIES
import com.github.mohamedwael.movieapp.applevel.MOVIE_ID
import com.github.mohamedwael.movieapp.response.Movie
import com.github.mohamedwael.movieapp.response.Movies
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RestClient {

    @GET(MOVIES)
    fun getMovies(): Observable<Movies>

    @GET("{$MOVIE_ID}")
    fun getMovieById(@Path(MOVIE_ID) movieId: String): Observable<Movie>
}