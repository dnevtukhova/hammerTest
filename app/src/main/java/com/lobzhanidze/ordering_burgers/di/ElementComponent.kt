package com.lobzhanidze.ordering_burgers.di

import android.app.Application
import com.lobzhanidze.ordering_burgers.presentation.view.ElementBurgerFragment
import dagger.android.AndroidInjectionModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ElementModule::class, AndroidInjectionModule::class])
interface ElementComponent {
    fun inject(app: Application)
    fun inject(elementBurgerFragment: ElementBurgerFragment)
}