package com.prabudi.getapp.data.model.home


import com.google.gson.annotations.SerializedName

data class Promo(
    @SerializedName("data")
    val `data`: List<PromoList>?,
    @SerializedName("title")
    val title: String?
)