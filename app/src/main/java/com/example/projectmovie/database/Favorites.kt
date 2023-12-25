package com.example.projectmovie.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "favorite_movies")
data class Favorites(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "year") val year: String?,
    @ColumnInfo(name = "img") val img: String?,
    @ColumnInfo(name = "isFavoriteAdded") val isFavoriteAdded: Boolean = false
)