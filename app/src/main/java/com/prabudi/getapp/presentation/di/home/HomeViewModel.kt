package com.prabudi.getapp.presentation.di.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.prabudi.getapp.domain.home.GetMenuPromoUseCase
import com.prabudi.getapp.domain.home.GetMenuUseCase
import com.prabudi.getapp.domain.home.UpdateMenuPromoUseCase
import com.prabudi.getapp.domain.home.UpdateMenuUseCase

class HomeViewModel(
    private val getMenuUseCase: GetMenuUseCase,
    private val getMenuPromoUseCase: GetMenuPromoUseCase,
    private val updateMenuUseCase: UpdateMenuUseCase,
    private val updateMenuPromoUseCase: UpdateMenuPromoUseCase
): ViewModel() {

    fun getMenu() = liveData {
        Log.i("TAG","home view model getMenu")
        val menuList = getMenuUseCase.execute()
        emit(menuList)
    }

    fun getMenuPromo() = liveData {
        Log.i("TAG","home view model getMenuPromo")
        val menuPromoList = getMenuPromoUseCase.execute()
        emit(menuPromoList)
    }

    fun updateMenu() = liveData {
        val menuList = updateMenuUseCase.execute()
        emit(menuList)
    }

    fun updateMenuPromo() = liveData {
        val menuPromoList = updateMenuPromoUseCase.execute()
        emit(menuPromoList)
    }
}