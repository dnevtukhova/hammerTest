package com.example.filmsearch.data

import android.content.Context
import com.example.filmsearch.data.db.ElementsDb
import com.example.filmsearch.data.entity.ElementItem
import io.reactivex.Observable
//import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import java.util.concurrent.Executors
import javax.inject.Inject

class ElementRepository @Inject constructor(){
    private val TAG = "FilmRepository"

  suspend fun addElementList(context: Context, list: MutableList<ElementItem>){

      coroutineScope {
          launch {
              withContext(Dispatchers.Default){
                  val elementDb = ElementsDb.getInstance(context)
                  elementDb?.getElementItemsDao()?.setElementItems(list)
              }
          }
      }
    }

   suspend fun getElementList(context: Context): MutableList<ElementItem>{

       var list = mutableListOf<ElementItem>()
       runBlocking {
           val elementDb = ElementsDb.getInstance(context)
           list.addAll(elementDb?.getElementItemsDao()?.getElementItems()!!)
       }
return list
    }
}