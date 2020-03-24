package com.github.mohamedwael.core.data

import com.github.mohamedwael.core.domain.ErrorHandler
import com.github.mohamedwael.core.domain.Movies

class MoviesRepo(private val remoteMoviesDataSource: RemoteMoviesDataSource) {
    fun getMovies(onSuccess: (Movies) -> Unit, onError: (ErrorHandler) -> Unit) {
        remoteMoviesDataSource.getMovies(onSuccess, onError)
    }
}