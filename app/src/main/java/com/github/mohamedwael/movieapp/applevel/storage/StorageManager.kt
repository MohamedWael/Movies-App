package com.github.mohamedwael.movieapp.applevel.storage

import android.content.Context
import com.github.mohamedwael.movieapp.modules.movies.MoviesDataHandler

object StorageManager {

    lateinit var moviesDataHandler: MoviesDataHandler

    fun init(context: Context) {
        val db = AppDatabase.getDatabase(context)
        moviesDataHandler = MoviesDataHandler(db)
    }
}