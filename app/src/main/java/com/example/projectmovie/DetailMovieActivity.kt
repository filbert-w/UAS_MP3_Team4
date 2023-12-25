package com.example.projectmovie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.projectmovie.databinding.ActivityDetailMovieBinding
import com.example.projectmovie.fragment.FavoriteFragment
import com.example.projectmovie.modeldata.MovieDetailData
import com.example.projectmovie.repository.FavRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var detailMovieViewModel: DetailMovieViewModel
    private lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi ViewModelFactory dan ViewModel
        val application = application
        viewModelFactory = ViewModelFactory(application, FavRepository(application))
        detailMovieViewModel = ViewModelProvider(this, viewModelFactory).get(DetailMovieViewModel::class.java)

        // Mendapatkan data film dari Intent
        val imdbID: String? = intent.getStringExtra("imdbid")
        val apiKey = "423c782e"

        // Memanggil API untuk mendapatkan detail film berdasarkan imdbID
        RClient.instances.getDetailMovie(imdbID, apiKey).enqueue(object : Callback<MovieDetailData> {
            override fun onResponse(call: Call<MovieDetailData>, response: Response<MovieDetailData>) {
                if (response.isSuccessful) {
                    val movieDetail = response.body()

                    // Menampilkan detail film ke UI
                    binding.tvTahun.text = movieDetail?.Year
                    binding.tvJudulmovie.text = movieDetail?.Title

                    Glide.with(this@DetailMovieActivity)
                        .load(movieDetail?.gambar)
                        .into(binding.imgGambarposter)

                    // Mendapatkan tombol "Add to Favorite"
                    val button: Button = findViewById(R.id.button_add_to_favorite)
                    button.setOnClickListener {
                        // Menambahkan film ke daftar favorit
                        if (movieDetail != null) {
                            detailMovieViewModel.addMovieToFavorites(movieDetail)
                            Toast.makeText(this@DetailMovieActivity, "Added to Favorites", Toast.LENGTH_SHORT).show()

                            // Pindah ke halaman favorit
                            val intent = Intent(this@DetailMovieActivity, FavoriteFragment::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<MovieDetailData>, t: Throwable) {
                // Handle kegagalan mendapatkan data dari API
            }
        })
    }
}
