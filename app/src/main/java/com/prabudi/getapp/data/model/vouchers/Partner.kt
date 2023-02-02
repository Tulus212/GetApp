package com.prabudi.getapp.data.model.vouchers


import com.google.gson.annotations.SerializedName

data class Partner(
    @SerializedName("DisplayValue")
    val displayValue: String?,
    @SerializedName("ID")
    val iD: String,
    @SerializedName("RSN")
    val rSN: String?
)