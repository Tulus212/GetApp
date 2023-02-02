package com.prabudi.getapp.data.model.home


import com.google.gson.annotations.SerializedName

data class Home(
    @SerializedName("data")
    val `data`: Data?
)