package com.github.mohamedwael.movieapp.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.mohamedwael.core.data.MoviesRepo

object MoviesViewModelFactory : ViewModelProvider.Factory {

    lateinit var moviesRepo: MoviesRepo

    fun inject(moviesRepo: MoviesRepo) {
        MoviesViewModelFactory.moviesRepo = moviesRepo
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (MoviesViewModel::class.java.isAssignableFrom(modelClass)) {
            return MoviesViewModel(moviesRepo) as T
        } else {
            throw IllegalStateException("Cannot create MoviesViewModel")
        }
    }

}