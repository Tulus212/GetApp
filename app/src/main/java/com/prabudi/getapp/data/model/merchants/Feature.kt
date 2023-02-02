package com.prabudi.getapp.data.model.merchants


import com.google.gson.annotations.SerializedName

data class Feature(
    @SerializedName("ImageURL")
    val imageURL: String?,
    @SerializedName("ThumbnailURL")
    val thumbnailURL: String?
)