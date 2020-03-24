package com.github.mohamedwael.movieapp.modules.moviedetails.viewmodel

import androidx.lifecycle.MediatorLiveData
import com.github.mohamedwael.core.data.MovieByIdRepo
import com.github.mohamedwael.movieapp.applevel.storage.StorageManager
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.MovieItem
import com.github.mohamedwael.movieapp.base.MoviesBaseViewModel

class MovieDetailsViewModel(private val movieByIdRepo: MovieByIdRepo) : MoviesBaseViewModel() {
    val movie = MediatorLiveData<MovieItem>()

    fun getMovieById(movieId: Int?) {
        if (movieId != null) {
            movie.addSource(StorageManager.moviesDataHandler.getItemByParam(movieId)) {
                movie.value = it
            }
            if (movie.value == null) getRemoteMovieById(movieId)
        }
    }

    private fun getRemoteMovieById(movieId: Int) {
        showLoadingLiveData.value = true
        movieByIdRepo.getMovieById(movieId.toString(), {
            showLoadingLiveData.value = false
        }, {
            showLoadingLiveData.value = false
            showErrorLiveData.value = it
        })
    }
}
