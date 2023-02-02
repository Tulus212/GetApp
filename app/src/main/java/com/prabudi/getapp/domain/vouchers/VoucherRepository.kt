package com.prabudi.getapp.domain.vouchers

import com.prabudi.getapp.data.model.vouchers.VoucherList

interface VoucherRepository {
    suspend fun getVoucher():List<VoucherList>?
    suspend fun updateVoucher():List<VoucherList>?
}