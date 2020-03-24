package com.github.mohamedwael.core.data

import com.github.mohamedwael.core.domain.ErrorHandler
import com.github.mohamedwael.core.domain.Movies

class MoviesRepo(private val remoteMovieDataSource: RemoteMovieDataSource) {
    fun getMovies(onSuccess: (Movies) -> Unit, onError: (ErrorHandler) -> Unit) {
        remoteMovieDataSource.getMovies(onSuccess, onError)
    }
}