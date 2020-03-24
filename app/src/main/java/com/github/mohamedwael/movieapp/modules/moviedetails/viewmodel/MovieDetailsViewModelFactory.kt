package com.github.mohamedwael.movieapp.modules.moviedetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.mohamedwael.core.data.MovieByIdRepo

object MovieDetailsViewModelFactory : ViewModelProvider.Factory {
    lateinit var movieByIdRepo: MovieByIdRepo

    fun inject(movieByIdRepo: MovieByIdRepo) {
        this.movieByIdRepo = movieByIdRepo
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (MovieDetailsViewModel::class.java.isAssignableFrom(modelClass)) {
            return MovieDetailsViewModel(movieByIdRepo) as T
        } else {
            throw IllegalStateException("Cannot create MoviesViewModel")
        }
    }
}