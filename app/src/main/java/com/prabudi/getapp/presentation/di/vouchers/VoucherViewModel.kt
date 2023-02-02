package com.prabudi.getapp.presentation.di.vouchers

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.prabudi.getapp.domain.vouchers.GetVoucherUseCase

class VoucherViewModel(
    private val getVoucherUseCase: GetVoucherUseCase
): ViewModel() {

    fun getVoucher() = liveData {
        Log.i("TAG","home view model getMenu")
        val voucherList = getVoucherUseCase.execute()
        emit(voucherList)
    }

}