package com.github.mohamedwael.core.data

import com.github.mohamedwael.core.domain.ErrorHandler
import com.github.mohamedwael.core.domain.Movie

class MovieByIdRepo(private val movieByIdDataSource: MovieByIdDataSource) {
    fun getMovieById(
        movieId: String,
        onSuccess: (Movie) -> Unit,
        onError: (ErrorHandler) -> Unit
    ) {
        movieByIdDataSource.getMovieById(movieId, onSuccess, onError)
    }
}