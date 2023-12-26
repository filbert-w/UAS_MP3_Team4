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
//        binding.rvFavorite.setHasFixedSize(true)
//        binding.rvFavorite.layoutManager = LinearLayoutManager(this)
//        val list = ArrayList<MovieData>()

        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.rvFavorite.adapter = MovieAdapter(list, this)

        appDb = AppDatabase.getDatabase(this)
        val movies = appDb.movieDao().getAll()

//        readData()

//        binding.rvFavorite.apply {
            val layoutManager = LinearLayoutManager(this@FavoriteActivity)
            val adapter = MovieAdapter2(movies)
//        }

        binding.rvFavorite.layoutManager = layoutManager
        binding.rvFavorite.adapter = adapter


//        binding.btnWriteData.setOnClickListener {
//            writeData()
//        }
//
//        binding.btnReadData.setOnClickListener {
//            readData()
//        }

//        binding.btnDeleteAll.setOnClickListener {
//            GlobalScope.launch {
//                appDb.movieDao().deleteAll()
//            }
//        }
    }

//    private fun writeData(){
//        val firstName = binding.etFirstName.text.toString()
//        val lastName = binding.etLastName.text.toString()
//        val rollNo = binding.etRollNo.text.toString()
//
//        if (firstName.isNotEmpty() && lastName.isNotEmpty() && rollNo.isNotEmpty()){
//            val movie = Movie(
//                null, firstName, lastName
//            )
//            GlobalScope.launch(Dispatchers.IO) {
//                appDb.movieDao().insert(movie)
//            }
//
//            binding.etFirstName.text.clear()
//            binding.etLastName.text.clear()
//            binding.etRollNo.text.clear()
//
//            Toast.makeText(this@FavoriteActivity, "Successfully Written", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this@FavoriteActivity, "Please Enter Data", Toast.LENGTH_SHORT).show()
//        }
//    }

//    private suspend fun displayData(movie: List<Movie>){
//        withContext(Dispatchers.Main){
////            binding.tvFirstName.text = movie.title
////            binding.tvLastName.text = movie.year
////            binding.tvRollNo.text = ""
//
//        }
//    }

//    private fun readData(){
////        val rollNo = binding.etRollNoRead.text.toString()
//
////        if (rollNo.isNotEmpty()){
//            lateinit var movie: List<Movie>
//
//            GlobalScope.launch {
//                movie = appDb.movieDao().getAll()
//                displayData(movie)
//            }
////        }
//    }
}