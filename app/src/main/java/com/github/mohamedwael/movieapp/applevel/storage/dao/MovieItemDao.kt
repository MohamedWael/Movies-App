package com.github.mohamedwael.movieapp.applevel.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.MovieItem

@Dao
interface MovieItemDao {

    @Query("SELECT * from MovieItem")
    fun getAllMovies(): LiveData<List<MovieItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(movieItem: MovieItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllMovies(movies: List<MovieItem>)

    @Query("DELETE FROM MovieItem")
    fun deleteAll()
}