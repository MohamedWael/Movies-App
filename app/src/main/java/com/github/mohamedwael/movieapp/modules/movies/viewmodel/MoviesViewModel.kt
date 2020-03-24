package com.github.mohamedwael.movieapp.modules.movies.viewmodel

import com.github.mohamedwael.core.data.MoviesRepo
import com.github.mohamedwael.movieapp.applevel.storage.StorageManager
import com.github.mohamedwael.movieapp.base.MoviesBaseViewModel

class MoviesViewModel(private val moviesRepo: MoviesRepo) : MoviesBaseViewModel() {
    val moviesLiveData = StorageManager.moviesDataHandler.getItems()

    fun getData() {
        if (moviesLiveData.value == null || moviesLiveData.value?.size == 0) {
            showLoadingLiveData.value = true
            moviesRepo.getMovies({
                showLoadingLiveData.value = false
            }, {
                showErrorLiveData.value = it
                showLoadingLiveData.value = false
            })
        }
    }
}