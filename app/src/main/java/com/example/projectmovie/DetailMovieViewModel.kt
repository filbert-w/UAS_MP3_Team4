package com.example.projectmovie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.projectmovie.database.Favorites
import com.example.projectmovie.modeldata.MovieDetailData
import com.example.projectmovie.repository.FavRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailMovieViewModel(application: Application, private val favRepository: FavRepository) : AndroidViewModel(application) {
    private val _isFavoriteAdded = MutableLiveData<Boolean>()
    val isFavoriteAdded: LiveData<Boolean>
        get() = _isFavoriteAdded

    fun addMovieToFavorites(movieDetail: MovieDetailData) {
        val favoriteMovie = Favorites(
            title = movieDetail.Title,
            year = movieDetail.Year,
            img = movieDetail.gambar,
            isFavoriteAdded = true
        )

        viewModelScope.launch(Dispatchers.IO) {
            favRepository.addFavoriteMovie(favoriteMovie)
            _isFavoriteAdded.postValue(true)
        }
    }
}

