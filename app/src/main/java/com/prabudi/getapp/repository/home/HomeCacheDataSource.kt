package com.prabudi.getapp.repository.home

import com.prabudi.getapp.data.model.home.MenuList
import com.prabudi.getapp.data.model.home.PromoList

interface HomeCacheDataSource {
    suspend fun getHomeMenuFromCache():List<MenuList>
    suspend fun saveHomeMenuFromCache(menu:List<MenuList>)

    suspend fun getHomeMenuPromoFromCache():List<PromoList>
    suspend fun saveHomeMenuPromoFromCache(menu:List<PromoList>)
}