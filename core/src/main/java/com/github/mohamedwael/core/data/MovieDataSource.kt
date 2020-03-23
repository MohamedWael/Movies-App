package com.github.mohamedwael.core.data

import com.github.mohamedwael.core.domain.Movies

interface MovieDataSource {
    fun getMovies(): Movies
    fun setMovies(movies: Movies)
}