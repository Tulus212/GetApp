package com.prabudi.getapp.repository.home

import com.prabudi.getapp.data.api.ApiService
import com.prabudi.getapp.data.model.home.Home
import retrofit2.Response

class HomeRemoteDataSourceImpl(private val apiService: ApiService) : HomeRemoteDataSource {
    override suspend fun getHome(): Response<Home> = apiService.getHomeData()
}