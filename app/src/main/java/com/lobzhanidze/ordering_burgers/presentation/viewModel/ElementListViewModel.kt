package com.lobzhanidze.ordering_burgers.presentation.viewModel

import android.content.Context
import android.provider.Settings
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmsearch.data.ElementRepository
import com.example.filmsearch.data.entity.ElementItem
import com.lobzhanidze.ordering_burgers.domain.ElementInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ElementListViewModel @Inject constructor(
    private val elementInteractor: ElementInteractor,
    private val elementRepository: ElementRepository
) : ViewModel() {
    private val _elementList = MutableStateFlow(mutableListOf<ElementItem>())
    val elementList: StateFlow<MutableList<ElementItem>> = _elementList

    fun loadElementList(context: Context, page: Int) {
        viewModelScope.launch {
            if (isAirplaneModeOn(context)){
                _elementList.value = elementRepository.getElementList(context)
            } else {
                elementInteractor.getFilms(page).collectLatest { elementList ->
                    withContext(Dispatchers.IO) {

                        elementRepository.addElementList(context, elementList)
                    }
                    _elementList.value = elementRepository.getElementList(context)
                }
            }
        }
    }

    private fun isAirplaneModeOn(context: Context): Boolean {
        return Settings.System.getInt(
            context.contentResolver,
            Settings.Global.AIRPLANE_MODE_ON, 0
        ) !== 0
    }
}