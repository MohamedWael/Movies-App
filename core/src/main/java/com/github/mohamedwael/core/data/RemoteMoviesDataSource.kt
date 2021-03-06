package com.github.mohamedwael.core.data

import com.github.mohamedwael.core.domain.ErrorHandler
import com.github.mohamedwael.core.domain.Movies

interface RemoteMoviesDataSource {
    fun getMovies(onSuccess: (Movies) -> Unit, onError:(ErrorHandler)->Unit)
}

