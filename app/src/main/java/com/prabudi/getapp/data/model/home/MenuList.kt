package com.prabudi.getapp.data.model.home

import com.google.gson.annotations.SerializedName

data class MenuList(
    @SerializedName("id")
    val id: String,
    @SerializedName("deeplink")
    val deeplink: String?,
    @SerializedName("enable")
    val enable: Boolean?,
    @SerializedName("label")
    val label: String?,
    @SerializedName("logoUrl")
    val logoUrl: String?,
    @SerializedName("visible")
    val visible: Boolean?
)