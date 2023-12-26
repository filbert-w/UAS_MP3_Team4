package com.example.projectmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.projectmovie.databinding.ActivityDetailMovieBinding
import com.example.projectmovie.databinding.ActivityFavoriteBinding
import com.example.projectmovie.databinding.ActivityMainBinding
import com.example.projectmovie.modeldata.MovieDetailData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailMovieBinding
    private lateinit var appDb: AppDatabase
    var b:Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        b = intent.extras
        val i = b?.getString("imdbid")
        val apikey = "423c782e"

        appDb = AppDatabase.getDatabase(this)

        RClient.instances.getDetailMovie(i, apikey).enqueue(object : Callback<MovieDetailData>{
            override fun onResponse(
                call: Call<MovieDetailData>,
                response: Response<MovieDetailData>
            ) {
                binding.tvTahun.text = response.body()?.Year
                binding.tvJudulmovie.text = response.body()?.Title
                binding.tvTglrilis.text = response.body()?.rilis


                Glide.with(this@DetailMovieActivity).load(response.body()?.gambar).into(binding.imgGambarposter)
            }

            override fun onFailure(call: Call<MovieDetailData>, t: Throwable){

            }
        })

        val button : Button = findViewById(R.id.button_add_to_favorite)
        button.setOnClickListener{
            writeData()
        }
    }

    private fun writeData(){
        val judul = binding.tvJudulmovie.text.toString()
        val tahun = binding.tvTahun.text.toString()

        if (judul.isNotEmpty() && tahun.isNotEmpty()){
            val movie = Movie(
                null, judul, tahun
            )
            GlobalScope.launch(Dispatchers.IO) {
                appDb.movieDao().insert(movie)
            }

            Toast.makeText(this@DetailMovieActivity, "Successfully Written", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@DetailMovieActivity, "Please Enter Data", Toast.LENGTH_SHORT).show()
        }
    }
}