package com.example.projectmovie

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Movie :: class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }

        }

    }

}