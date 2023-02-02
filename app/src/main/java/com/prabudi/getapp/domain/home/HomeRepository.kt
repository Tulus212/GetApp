package com.prabudi.getapp.domain.home

import com.prabudi.getapp.data.model.home.MenuList
import com.prabudi.getapp.data.model.home.PromoList

interface HomeRepository {
    suspend fun getMenu():List<MenuList>?
    suspend fun updateMenu():List<MenuList>?
    suspend fun getMenuPromo():List<PromoList>?
    suspend fun updateMenuPromo():List<PromoList>?
}