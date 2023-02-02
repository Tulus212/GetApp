package com.prabudi.getapp.domain.merchants

import com.prabudi.getapp.data.model.merchants.MerchantList

interface MerchantRepository {
    suspend fun getMerchant(page:String):List<MerchantList>?
}