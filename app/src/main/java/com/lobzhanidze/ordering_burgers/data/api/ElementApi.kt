package com.example.filmsearch.data.api


import com.example.filmsearch.data.entity.ElementModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ElementApi {
    @GET("top")
   suspend fun getFilmTop(@Query("page") page: Int): ElementModel
}