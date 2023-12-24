package com.example.projectmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bumptech.glide.Glide
import com.example.projectmovie.databinding.ActivityDetailMovieBinding
import com.example.projectmovie.databinding.ActivityMainBinding
import com.example.projectmovie.modeldata.MovieDetailData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailMovieBinding
    var b:Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        b = intent.extras
        val i = b?.getString("imdbid")
        val apikey = "423c782e"

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
        button.setOnClickListener(){
            //menambahkan film ke favorite
        }
    }
}