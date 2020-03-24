package com.github.mohamedwael.movieapp.movies

import androidx.lifecycle.LiveData
import com.github.mohamedwael.movieapp.applevel.storage.AppDatabase
import com.github.mohamedwael.movieapp.applevel.storage.datahandler.DataHandler
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.MovieItem

class MoviesDataHandler(db: AppDatabase) : DataHandler<MovieItem>(db) {
    override fun insertItem(data: MovieItem, onSuccess: () -> Unit) {
        doAsync({ database.movieItemDao().addMovie(data) }, onSuccess)
    }

    override fun insertAll(data: List<MovieItem>, onSuccess: () -> Unit) {
        doAsync({ database.movieItemDao().addAllMovies(data) }, onSuccess)
    }

    override fun update(data: MovieItem, onSuccess: () -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(data: MovieItem, onSuccess: () -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(onSuccess: () -> Unit) {
        doAsync({ database.movieItemDao().deleteAll() }, onSuccess)
    }

    override fun getItems(): LiveData<List<MovieItem>> = database.movieItemDao().getAllMovies()


    override fun getItem(): LiveData<MovieItem> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}