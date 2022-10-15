package com.example.filmsearch.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "element_items")
data class ElementItem(
    @PrimaryKey(autoGenerate = true)
    var idFilm: Int = 0,
    var id: Int,
    var nameRu: String,
    var posterUrlPreview: String,
    var posterUrl: String,
    var year: String,
)