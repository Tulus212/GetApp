package com.prabudi.getapp.data.model.merchants


import com.google.gson.annotations.SerializedName

data class PartnerCategory(
    @SerializedName("DisplayValue")
    val displayValue: String?,
    @SerializedName("PartnerCategoryID")
    val partnerCategoryID: String?,
    @SerializedName("RSN")
    val rSN: String?
)