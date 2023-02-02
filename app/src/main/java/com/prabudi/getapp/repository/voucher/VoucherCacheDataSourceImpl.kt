package com.prabudi.getapp.repository.voucher

import com.prabudi.getapp.data.model.vouchers.VoucherList

class VoucherCacheDataSourceImpl : VoucherCacheDataSource {
    private var voucherList = ArrayList<VoucherList>()

    override suspend fun getVoucherFromCache(): List<VoucherList> {
        return voucherList
    }

    override suspend fun saveVoucherFromCache(menu: List<VoucherList>) {
        voucherList.clear()
        voucherList = ArrayList(menu)
    }
}