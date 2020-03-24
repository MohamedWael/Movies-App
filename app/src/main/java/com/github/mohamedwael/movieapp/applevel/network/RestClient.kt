package com.github.mohamedwael.movieapp.applevel.network

import com.github.mohamedwael.movieapp.applevel.MOVIES
import com.github.mohamedwael.movieapp.applevel.MOVIE_ID
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.MovieItem
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RestClient {

    @GET(MOVIES)
    fun getMovies(): Observable<MoviesResponse>

    @GET("$MOVIES/{$MOVIE_ID}")
    fun getMovieById(@Path(MOVIE_ID) movieId: String): Observable<MovieItem>
}