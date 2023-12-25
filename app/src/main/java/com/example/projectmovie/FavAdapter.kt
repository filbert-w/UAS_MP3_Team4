package com.example.projectmovie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectmovie.databinding.ListDatamovieBinding
import com.example.projectmovie.database.Favorites

class FavAdapter : RecyclerView.Adapter<FavAdapter.MovieViewHolder>() {

    private var listFav: List<Favorites> = ArrayList()

    inner class MovieViewHolder(itemView: ListDatamovieBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView

        fun bind(favorite: Favorites) {
            with(binding) {
                Glide.with(itemView).load(favorite.img).into(imgPoster)
                tvTitle.text = favorite.title
                tvYear.text = favorite.year
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ListDatamovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listFav[position])
    }

    override fun getItemCount(): Int = listFav.size

    // Use a more meaningful name based on your use case
    fun setFavoriteList(newList: LiveData<List<Favorites>>) {
        newList.observeForever { favorites ->
            favorites?.let {
                listFav = it
                notifyDataSetChanged()
            }
        }
    }
}
