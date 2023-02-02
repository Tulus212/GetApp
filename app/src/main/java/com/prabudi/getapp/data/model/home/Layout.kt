package com.prabudi.getapp.data.model.home


import com.google.gson.annotations.SerializedName

data class Layout(
    @SerializedName("menu")
    val menuLists: List<MenuList>?,
    @SerializedName("promo")
    val promo: Promo?
)