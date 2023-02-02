package com.prabudi.getapp.repository.voucher

import com.prabudi.getapp.data.model.vouchers.Vouchers
import retrofit2.Response

interface VoucherRemoteDataSource {
    suspend fun getVoucher(): Response<Vouchers>
}