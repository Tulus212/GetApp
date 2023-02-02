package com.prabudi.getapp.repository.merchant

import com.prabudi.getapp.data.model.merchants.Merchants
import retrofit2.Response

interface MerchantRemoteDataSource {
    suspend fun getMerchant(page:String): Response<Merchants>
}