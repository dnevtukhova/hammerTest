package com.lobzhanidze.ordering_burgers

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lobzhanidze.ordering_burgers.data.db.ElementItemDAO
import com.example.filmsearch.data.entity.ElementItem

@Database(entities = [ElementItem::class], version = 1)
abstract class AppDb : RoomDatabase(){
    abstract fun getElementItemsDao(): ElementItemDAO
}