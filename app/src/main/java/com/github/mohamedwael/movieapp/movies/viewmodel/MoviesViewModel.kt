package com.github.mohamedwael.movieapp.movies.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mohamedwael.core.data.MoviesRepo
import com.github.mohamedwael.core.domain.ErrorHandler
import com.github.mohamedwael.movieapp.applevel.storage.StorageManager

class MoviesViewModel(private val moviesRepo: MoviesRepo) : ViewModel() {
    val moviesLiveData = StorageManager.moviesDataHandler.getItems()
    val showLoadingLiveData = MutableLiveData<Boolean>()
    val showErrorLiveData = MutableLiveData<ErrorHandler>()

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