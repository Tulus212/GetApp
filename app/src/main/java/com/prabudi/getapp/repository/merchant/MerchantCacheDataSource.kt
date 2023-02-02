package com.prabudi.getapp.repository.merchant

import com.prabudi.getapp.data.model.merchants.MerchantList

interface MerchantCacheDataSource {
    suspend fun getMerchantFromCache(page:String):List<MerchantList>
    suspend fun saveMerchantFromCache(menu:List<MerchantList>)
}