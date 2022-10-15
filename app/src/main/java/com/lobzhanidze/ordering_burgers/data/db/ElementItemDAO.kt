package com.lobzhanidze.ordering_burgers.data.db

import androidx.room.*
import com.example.filmsearch.data.entity.ElementItem


@Dao
interface ElementItemDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun setElementItems(elements: MutableList<ElementItem>)

    @Query("SELECT * FROM element_items")
    suspend fun getElementItems(): MutableList<ElementItem>
}