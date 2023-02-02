package com.prabudi.getapp.repository.voucher

import com.prabudi.getapp.data.model.vouchers.VoucherList

interface VoucherCacheDataSource {
    suspend fun getVoucherFromCache():List<VoucherList>
    suspend fun saveVoucherFromCache(menu:List<VoucherList>)
}