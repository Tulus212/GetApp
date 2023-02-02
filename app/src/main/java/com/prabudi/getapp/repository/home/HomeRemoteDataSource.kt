package com.prabudi.getapp.repository.home

import com.prabudi.getapp.data.model.home.Home
import retrofit2.Response

interface HomeRemoteDataSource {
    suspend fun getHome(): Response<Home>
}