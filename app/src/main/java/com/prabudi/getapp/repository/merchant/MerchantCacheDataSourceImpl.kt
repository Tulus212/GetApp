package com.prabudi.getapp.repository.merchant

import com.prabudi.getapp.data.model.merchants.MerchantList

class MerchantCacheDataSourceImpl : MerchantCacheDataSource {
    private var merchantList = ArrayList<MerchantList>()

    override suspend fun getMerchantFromCache(page:String): List<MerchantList> {
        return merchantList
    }

    override suspend fun saveMerchantFromCache(menu: List<MerchantList>) {
        merchantList.clear()
        merchantList = ArrayList(menu)
    }
}