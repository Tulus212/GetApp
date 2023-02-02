package com.prabudi.getapp.repository.voucher

import com.prabudi.getapp.data.api.ApiService
import com.prabudi.getapp.data.model.vouchers.Vouchers
import retrofit2.Response

class VoucherRemoteDataSourceImpl(private val apiService: ApiService) : VoucherRemoteDataSource {
    override suspend fun getVoucher(): Response<Vouchers> = apiService.getVoucherList()
}