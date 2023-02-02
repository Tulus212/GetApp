package com.prabudi.getapp.presentation.di.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prabudi.getapp.domain.home.GetMenuPromoUseCase
import com.prabudi.getapp.domain.home.GetMenuUseCase
import com.prabudi.getapp.domain.home.UpdateMenuPromoUseCase
import com.prabudi.getapp.domain.home.UpdateMenuUseCase

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(
    private val getMenuUseCase: GetMenuUseCase,
    private val getMenuPromoUseCase: GetMenuPromoUseCase,
    private val updateMenuUseCase: UpdateMenuUseCase,
    private val updateMenuPromoUseCase: UpdateMenuPromoUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(
            getMenuUseCase,
            getMenuPromoUseCase,
            updateMenuUseCase,
            updateMenuPromoUseCase
        ) as T
    }
}