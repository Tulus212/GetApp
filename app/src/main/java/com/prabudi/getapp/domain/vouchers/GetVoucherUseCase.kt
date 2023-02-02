package com.prabudi.getapp.domain.vouchers

import com.prabudi.getapp.data.model.vouchers.VoucherList

class GetVoucherUseCase(private val voucherRepository: VoucherRepository) {
    suspend fun execute():List<VoucherList>? = voucherRepository.getVoucher()
}