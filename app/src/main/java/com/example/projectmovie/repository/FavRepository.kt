package com.example.projectmovie.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.projectmovie.database.Favorites
import com.example.projectmovie.database.FavoritesDao
import com.example.projectmovie.database.FavRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavRepository(application: Application) {

    private val favoritesDao: FavoritesDao
    val allFavorites: LiveData<List<Favorites>>  // Jadikan LiveData sebagai properti publik

    init {
        val database = FavRoomDatabase.getDatabase(application)
        favoritesDao = database.favoritesDao()
        allFavorites = favoritesDao.getAllFavorite()
    }

    suspend fun addFavoriteMovie(movie: Favorites) {
        withContext(Dispatchers.IO) {
            try {
                favoritesDao.insertFavoriteMovie(movie)
                // Log success or handle it appropriately
            } catch (e: Exception) {
                // Log or handle the exception
            }
        }
    }

    // Metode baru untuk mendapatkan daftar favorit yang hanya mencakup item yang ditambahkan sebagai favorit
    fun getAddedFavorites(): LiveData<List<Favorites>> {
        return favoritesDao.getAddedFavorites()
    }
}
