package com.prabudi.getapp.presentation.di.vouchers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prabudi.getapp.domain.vouchers.GetVoucherUseCase

@Suppress("UNCHECKED_CAST")
class VoucherViewModelFactory(
    private val getVoucherUseCase: GetVoucherUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VoucherViewModel(
            getVoucherUseCase
        ) as T
    }
}