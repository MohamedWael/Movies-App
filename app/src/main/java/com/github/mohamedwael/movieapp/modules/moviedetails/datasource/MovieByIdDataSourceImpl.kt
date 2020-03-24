package com.github.mohamedwael.movieapp.modules.moviedetails.datasource

import com.github.mohamedwael.core.data.MovieByIdDataSource
import com.github.mohamedwael.core.domain.ErrorHandler
import com.github.mohamedwael.core.domain.Movie
import com.github.mohamedwael.movieapp.applevel.network.RestClient
import com.github.mohamedwael.movieapp.applevel.network.networkservice.network
import com.github.mohamedwael.movieapp.applevel.storage.StorageManager
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.MovieItem
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.toMovie

class MovieByIdDataSourceImpl : MovieByIdDataSource {
    override fun getMovieById(
        movieId: String,
        onSuccess: (Movie) -> Unit,
        onError: (ErrorHandler) -> Unit
    ) {
        network<MovieItem> {
            execute(createRestClient(RestClient::class.java).getMovieById(movieId), {
                StorageManager.moviesDataHandler.update(it) {
                    onSuccess(it.toMovie())
                }
            }, onError)
        }
    }
}