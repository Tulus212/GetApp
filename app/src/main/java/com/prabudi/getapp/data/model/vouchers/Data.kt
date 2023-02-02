package com.prabudi.getapp.data.model.vouchers


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("list")
    val list: List<VoucherList>?
)