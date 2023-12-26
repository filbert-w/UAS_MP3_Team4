package com.example.projectmovie

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    fun getAll(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAll()

}