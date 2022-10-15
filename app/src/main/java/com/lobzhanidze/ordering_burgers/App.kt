package com.lobzhanidze.ordering_burgers

import android.app.Application
import com.example.filmsearch.data.db.ElementsDb
import com.lobzhanidze.ordering_burgers.di.DaggerElementComponent
import com.lobzhanidze.ordering_burgers.di.ElementComponent
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import javax.inject.Inject

class App :Application(){
    val elementComponent: ElementComponent = DaggerElementComponent.create()

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        elementComponent.inject(this)
        instance = this
    }

    @Inject
   fun initDb(){
        Executors.newSingleThreadScheduledExecutor().execute(
            Runnable {
                runBlocking { ElementsDb.getInstance(applicationContext)?.getElementItemsDao()?.getElementItems() }

            }
        )
    }
}