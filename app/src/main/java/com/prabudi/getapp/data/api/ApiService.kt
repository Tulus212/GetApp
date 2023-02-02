package com.prabudi.getapp.data.api

import com.prabudi.getapp.data.model.home.Home
import com.prabudi.getapp.data.model.merchants.Merchants
import com.prabudi.getapp.data.model.vouchers.Vouchers
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("home")
    suspend fun getHomeData(): Response<Home>

    @GET("merchants?")
    suspend fun getMerchantList(
        @Query("page") page: String,
    ): Response<Merchants>

    @GET("vouchers")
    suspend fun getVoucherList(): Response<Vouchers>
}