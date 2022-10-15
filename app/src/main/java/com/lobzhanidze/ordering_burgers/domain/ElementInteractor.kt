package com.lobzhanidze.ordering_burgers.domain

import com.example.filmsearch.data.api.ElementApi
import com.example.filmsearch.data.entity.ElementItem
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ElementInteractor @Inject constructor (
    private val elementApi: ElementApi
) {
    private val TAG = "ElementInteractor"

    fun getFilms(page: Int) = flow {
        val elementItemList = mutableListOf<ElementItem>()
        elementApi.getFilmTop(page).films.forEach {
            val elem = ElementItem(
                0,
                it.filmId,
                it.nameRu,
                it.posterUrlPreview,
                it.posterUrl,
                it.year
            )
            elementItemList.add(elem)
        }
        emit(elementItemList)
    }.flowOn(Dispatchers.IO)
}