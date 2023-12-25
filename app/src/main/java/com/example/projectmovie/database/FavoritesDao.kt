package com.example.projectmovie.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovie(movie: Favorites)

    @Query("SELECT * FROM favorite_movies")
    fun getAllFavorite(): LiveData<List<Favorites>>

    @Query("SELECT * FROM favorite_movies WHERE isFavoriteAdded = 1")
    fun getAddedFavorites(): LiveData<List<Favorites>>
}
