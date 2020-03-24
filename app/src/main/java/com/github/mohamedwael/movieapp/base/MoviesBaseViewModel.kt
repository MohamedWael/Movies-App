package com.github.mohamedwael.movieapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mohamedwael.core.domain.ErrorHandler

open class MoviesBaseViewModel : ViewModel() {
    val showLoadingLiveData = MutableLiveData<Boolean>()
    val showErrorLiveData = MutableLiveData<ErrorHandler>()
}