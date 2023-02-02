package com.prabudi.getapp.presentation.di.merchants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prabudi.getapp.domain.merchants.GetMerchantUseCase

@Suppress("UNCHECKED_CAST")
class MerchantViewModelFactory(
    private val getMerchantUseCase: GetMerchantUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MerchantViewModel(
            getMerchantUseCase
        ) as T
    }
}