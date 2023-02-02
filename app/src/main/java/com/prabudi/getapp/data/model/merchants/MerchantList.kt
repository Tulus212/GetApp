package com.prabudi.getapp.data.model.merchants

import com.google.gson.annotations.SerializedName

data class MerchantList (
    @SerializedName("ID")
    val iD: String,
    @SerializedName("DisplayValue")
    val displayValue: String?,
    @SerializedName("Images")
    val images: Images?,
    @SerializedName("Name")
    val name: String?,
    @SerializedName("PartnerCategory")
    val partnerCategory: PartnerCategory?,
    @SerializedName("RSN")
    val rSN: String?,
    @SerializedName("URL")
    val uRL: String?,
    @SerializedName("WebsiteProfile")
    val websiteProfile: String?
)