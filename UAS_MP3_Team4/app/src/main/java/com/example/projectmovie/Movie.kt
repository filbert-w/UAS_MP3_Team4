package com.example.projectmovie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey(autoGenerate = true) val id:Int?,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "year") val year: String?,
)
