package com.github.mohamedwael.core.data

import com.github.mohamedwael.core.domain.Movies

class MoviesRepo(private val movieDataSource: MovieDataSource) {
    fun getMovies(): Movies = movieDataSource.getMovies()
    fun setMovies(movies: Movies) = movieDataSource.setMovies(movies)
}