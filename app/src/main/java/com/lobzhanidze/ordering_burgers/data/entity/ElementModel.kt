package com.example.filmsearch.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ElementModel(
    var pagesCount: Int,
    var films: MutableList<Element>
) : Parcelable

@Parcelize
class Element(
    var filmId: Int,
    var nameRu: String,
    var year: String,
    var rating: String,
    var posterUrl: String,
    var posterUrlPreview: String
) : Parcelable
