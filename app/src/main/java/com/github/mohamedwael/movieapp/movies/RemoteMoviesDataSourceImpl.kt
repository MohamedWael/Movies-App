package com.github.mohamedwael.movieapp.movies

import com.github.mohamedwael.core.data.RemoteMovieDataSource
import com.github.mohamedwael.core.domain.ErrorHandler
import com.github.mohamedwael.core.domain.Movies
import com.github.mohamedwael.movieapp.applevel.network.RestClient
import com.github.mohamedwael.movieapp.applevel.network.networkservice.network
import com.github.mohamedwael.movieapp.applevel.storage.StorageManager
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.MoviesResponse
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.toMovies

class RemoteMoviesDataSourceImpl : RemoteMovieDataSource {

    override fun getMovies(onSuccess: (Movies) -> Unit, onError: (ErrorHandler) -> Unit) {
        network<MoviesResponse> {
            execute(createRestClient(RestClient::class.java).getMovies(), {
                StorageManager.moviesDataHandler.insertAll(it) {
                    onSuccess(it.toMovies())
                }
            }, onError)
        }
    }

}