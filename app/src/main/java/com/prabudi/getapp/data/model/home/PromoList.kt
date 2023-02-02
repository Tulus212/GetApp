package com.prabudi.getapp.data.model.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PromoList(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("order")
    val order: Int?,
    @SerializedName("url")
    val url: String?
): Parcelable