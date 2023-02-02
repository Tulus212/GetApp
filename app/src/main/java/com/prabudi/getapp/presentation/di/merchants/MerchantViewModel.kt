package com.prabudi.getapp.presentation.di.merchants

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.prabudi.getapp.domain.merchants.GetMerchantUseCase

class MerchantViewModel(
    private val getMerchantUseCase: GetMerchantUseCase
): ViewModel() {

    fun getMerchant(page:String) = liveData {
        Log.i("TAG","home view model getMenu")
        val merchantList = getMerchantUseCase.execute(page)
        emit(merchantList)
    }
}