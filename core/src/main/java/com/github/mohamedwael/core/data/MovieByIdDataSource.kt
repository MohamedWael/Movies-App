package com.github.mohamedwael.core.data

import com.github.mohamedwael.core.domain.ErrorHandler
import com.github.mohamedwael.core.domain.Movie

interface MovieByIdDataSource {
    fun getMovieById(
        movieId: String,
        onSuccess: (Movie) -> Unit,
        onError: (ErrorHandler) -> Unit
    )
}