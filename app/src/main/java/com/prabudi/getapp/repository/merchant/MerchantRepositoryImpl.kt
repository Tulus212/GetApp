package com.prabudi.getapp.repository.merchant

import android.util.Log
import com.prabudi.getapp.data.model.merchants.MerchantList
import com.prabudi.getapp.data.model.merchants.Merchants
import com.prabudi.getapp.domain.merchants.MerchantRepository
import retrofit2.Response

class MerchantRepositoryImpl(
    private val merchantRemoteDataSource: MerchantRemoteDataSource
) : MerchantRepository {
    override suspend fun getMerchant(page:String): List<MerchantList> {
        return getMerchantFromAPI(page)
    }

    private suspend fun getMerchantFromAPI(page:String): List<MerchantList> {
        lateinit var merchantList: List<MerchantList>
        merchantList = mutableListOf()
        try {
            val response : Response<Merchants> = merchantRemoteDataSource.getMerchant(page)
            val body: Merchants? = response.body()
            if(body!=null){
                if(body.data?.list?.size != 0) merchantList = body.data?.list!!
            }
        }catch (e: Exception){
            Log.i("TAG API", e.message.toString())
        }
        return merchantList
    }
}