package com.example.projectmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectmovie.databinding.ActivityFavoriteBinding
import com.example.projectmovie.modeldata.MovieData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var appDb: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDb = AppDatabase.getDatabase(this)
        val movies = appDb.movieDao().getAll()

        val layoutManager = LinearLayoutManager(this@FavoriteActivity)
        val adapter = MovieAdapter2(movies)

        binding.rvFavorite.layoutManager = layoutManager
        binding.rvFavorite.adapter = adapter
    }
}