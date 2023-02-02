package com.prabudi.getapp.repository.merchant

import com.prabudi.getapp.data.api.ApiService
import com.prabudi.getapp.data.model.merchants.Merchants
import retrofit2.Response

class MerchantRemoteDataSourceImpl(private val apiService: ApiService) : MerchantRemoteDataSource {
    override suspend fun getMerchant(page:String): Response<Merchants> = apiService.getMerchantList(page)
}