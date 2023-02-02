package com.prabudi.getapp.domain.vouchers

import com.prabudi.getapp.data.model.vouchers.VoucherList

class UpdateVoucherUseCase(private val voucherRepository: VoucherRepository) {
    suspend fun execute():List<VoucherList>? = voucherRepository.updateVoucher()
}