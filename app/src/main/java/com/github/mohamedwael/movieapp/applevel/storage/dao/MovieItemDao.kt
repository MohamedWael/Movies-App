package com.github.mohamedwael.movieapp.applevel.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.github.mohamedwael.movieapp.applevel.storage.dbentries.MovieItem

@Dao
interface MovieItemDao {

    @Query("SELECT * from MovieItem")
    fun getAllMovies(): LiveData<List<MovieItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovie(movieItem: MovieItem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovie(movieItem: MovieItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllMovies(movies: List<MovieItem>)

    @Query("DELETE FROM MovieItem")
    fun deleteAll()

    @Query("SELECT * from MovieItem WHERE id=:movieId")
    fun getMovieById(movieId: Int): LiveData<MovieItem>
}