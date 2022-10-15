package com.lobzhanidze.ordering_burgers.di

import com.example.filmsearch.data.ElementRepository
import com.example.filmsearch.data.api.ElementApi
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.lobzhanidze.ordering_burgers.domain.ElementInteractor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ElementModule {
    @Provides
    @Singleton
    fun provideInitRetrofit(okHttpClient: OkHttpClient): ElementApi = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/api/v2.2/films/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(ElementApi::class.java)

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                return@addInterceptor chain.proceed(
                    chain
                        .request()
                        .newBuilder()
                        .addHeader("X-API-KEY", "51ebe8b4-a4d2-49ce-ad54-cba690766d4b")
                        .build()
                )
            }
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }

    @Provides
    @Singleton
    fun provideElementInteractor(elementApi: ElementApi): ElementInteractor {
        return ElementInteractor(elementApi)
    }

    @Provides
    @Singleton
    fun provideFilmRepository(): ElementRepository = ElementRepository()
}