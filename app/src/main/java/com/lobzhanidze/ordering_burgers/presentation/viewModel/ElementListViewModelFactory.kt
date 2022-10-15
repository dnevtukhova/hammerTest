package com.lobzhanidze.ordering_burgers.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmsearch.data.ElementRepository
import com.lobzhanidze.ordering_burgers.domain.ElementInteractor
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ElementListViewModelFactory @Inject constructor(
    private val elementInteractor: ElementInteractor,
    private val elementRepository: ElementRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ElementListViewModel::class.java)) {
            return ElementListViewModel(elementInteractor, elementRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}