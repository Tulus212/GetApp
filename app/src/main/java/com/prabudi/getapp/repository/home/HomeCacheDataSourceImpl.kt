package com.prabudi.getapp.repository.home

import com.prabudi.getapp.data.model.home.MenuList
import com.prabudi.getapp.data.model.home.PromoList

class HomeCacheDataSourceImp : HomeCacheDataSource {
    private var menuList = ArrayList<MenuList>()
    private var menuPromoList = ArrayList<PromoList>()

    override suspend fun getHomeMenuFromCache(): List<MenuList> {
        return menuList
    }

    override suspend fun saveHomeMenuFromCache(menu: List<MenuList>) {
        menuList.clear()
        menuList = ArrayList(menu)
    }

    override suspend fun getHomeMenuPromoFromCache(): List<PromoList> {
        return menuPromoList
    }

    override suspend fun saveHomeMenuPromoFromCache(menu: List<PromoList>) {
        menuPromoList.clear()
        menuPromoList = ArrayList(menu)
    }
}