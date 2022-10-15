package com.example.filmsearch.data.db

import android.content.Context
import androidx.room.Room
import com.lobzhanidze.ordering_burgers.AppDb


object ElementsDb {
    private var INSTANCE: AppDb? = null

    fun getInstance(context: Context): AppDb? {
        if (INSTANCE == null){
            synchronized(AppDb::class){
                INSTANCE = Room
                    .databaseBuilder(context,
                        AppDb::class.java, "MyDb")
                    .build()
            }
        }
        return INSTANCE
    }

    fun destroyInstance(){
        INSTANCE?.close()
        INSTANCE = null
    }
}