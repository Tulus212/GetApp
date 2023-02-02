package com.prabudi.getapp.data.model.merchants


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("list")
    val list: List<MerchantList>?
)