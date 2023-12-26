package com.example.projectmovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter2(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter2.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_datamovie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.tv_title).text = movies[position].title
        holder.view.findViewById<TextView>(R.id.tv_year).text = movies[position].year
    }

    class ViewHolder(val view:View):RecyclerView.ViewHolder(view)
}
