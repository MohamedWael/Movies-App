package com.github.mohamedwael.movieapp.applevel.application

import android.app.Application
import com.github.mohamedwael.core.data.MoviesRepo
import com.github.mohamedwael.movieapp.applevel.BASE_API
import com.github.mohamedwael.movieapp.applevel.MOVIES_REPO
import com.github.mohamedwael.movieapp.applevel.ServiceLocator
import com.github.mohamedwael.movieapp.applevel.network.Retrofit
import com.github.mohamedwael.movieapp.applevel.storage.StorageManager
import com.github.mohamedwael.movieapp.movies.MoviesDataSourceImpl

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Retrofit.init(BASE_API)
        ServiceLocator.addService(MOVIES_REPO, MoviesRepo(MoviesDataSourceImpl()))

    }
}