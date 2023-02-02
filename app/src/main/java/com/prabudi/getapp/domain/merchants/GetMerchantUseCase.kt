package com.prabudi.getapp.domain.merchants

import com.prabudi.getapp.data.model.merchants.MerchantList

class GetMerchantUseCase(private val merchantRepository: MerchantRepository) {
    suspend fun execute(page:String):List<MerchantList>? = merchantRepository.getMerchant(page)
}