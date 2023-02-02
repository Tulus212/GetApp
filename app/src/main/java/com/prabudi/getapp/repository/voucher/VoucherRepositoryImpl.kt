package com.prabudi.getapp.repository.voucher

import android.util.Log
import com.prabudi.getapp.data.model.vouchers.VoucherList
import com.prabudi.getapp.data.model.vouchers.Vouchers
import com.prabudi.getapp.domain.vouchers.VoucherRepository
import retrofit2.Response

class VoucherRepositoryImpl(
    private val voucherRemoteDataSource: VoucherRemoteDataSource,
    private val voucherCacheDataSource: VoucherCacheDataSource
) : VoucherRepository {
    override suspend fun getVoucher(): List<VoucherList> {
        return getVoucherFromCache()
    }

    override suspend fun updateVoucher(): List<VoucherList> {
        val newVoucherList: List<VoucherList> = getVoucherFromAPI()
        voucherCacheDataSource.saveVoucherFromCache(newVoucherList)
        return newVoucherList
    }

    private suspend fun getVoucherFromAPI(): List<VoucherList> {
        lateinit var voucherList: List<VoucherList>
        voucherList = mutableListOf()
        try {
            val response : Response<Vouchers> = voucherRemoteDataSource.getVoucher()
            val body: Vouchers? = response.body()
            if(body!=null){
                if(body.data?.list?.size != 0) voucherList = body.data?.list!!
            }
        }catch (e: Exception){
            Log.i("TAG API", e.message.toString())
        }
        return voucherList
    }

    private suspend fun getVoucherFromCache(): List<VoucherList> {
        lateinit var voucherList: List<VoucherList>
        try {
            voucherList = voucherCacheDataSource.getVoucherFromCache()
        }catch (e: Exception){
            Log.i("TAG CACHE", e.message.toString())
        }
        if(voucherList.isNotEmpty()){
            return voucherList
        }else {
            voucherList = getVoucherFromAPI()
            voucherCacheDataSource.saveVoucherFromCache(voucherList)
        }
        return voucherList
    }
}