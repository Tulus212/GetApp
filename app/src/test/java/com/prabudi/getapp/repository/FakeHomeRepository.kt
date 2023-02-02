package com.prabudi.getapp.repository

import com.prabudi.getapp.data.model.home.MenuList
import com.prabudi.getapp.data.model.home.PromoList
import com.prabudi.getapp.domain.home.HomeRepository

class FakeHomeRepository : HomeRepository {
    private val menuList = mutableListOf<MenuList>()
    private val promoList = mutableListOf<PromoList>()

    init {
        menuList.add(MenuList("1", "overview1", true, "test", "https://firebasestorage.googleapis.com/v0/b/getplus-46d55.appspot.com/o/home_layout%2FicoShop%403x.png?alt=media&token=d40fed97-0165-4afa-bcfb-22786ecd4066", true))
        menuList.add(MenuList("2", "overview2", true, "date2", "https://firebasestorage.googleapis.com/v0/b/getplus-46d55.appspot.com/o/home_layout%2FicoShop%403x.png?alt=media&token=d40fed97-0165-4afa-bcfb-22786ecd4066", true))
        promoList.add(PromoList(1, "https://images-dev.mygetplus.id/promotion/banners/Screenshot 2022-12-20 112945.png", 1, "https://getplus.onelink.me/wOe0/jz5q23kf?browser=true"))
        promoList.add(PromoList(2, "https://images-dev.mygetplus.id/promotion/banners/Screenshot 2022-12-20 112945.png", 2, "https://getplus.onelink.me/wOe0/jz5q23kf?browser=true"))
    }

    override suspend fun getMenu(): List<MenuList> {
        return menuList
    }

    override suspend fun updateMenu(): List<MenuList> {
        menuList.clear()
        menuList.add(MenuList("3", "overview1", true, "test", "https://firebasestorage.googleapis.com/v0/b/getplus-46d55.appspot.com/o/home_layout%2FicoShop%403x.png?alt=media&token=d40fed97-0165-4afa-bcfb-22786ecd4066", true))
        menuList.add(MenuList("4", "overview2", true, "date2", "https://firebasestorage.googleapis.com/v0/b/getplus-46d55.appspot.com/o/home_layout%2FicoShop%403x.png?alt=media&token=d40fed97-0165-4afa-bcfb-22786ecd4066", true))

        return menuList
    }

    override suspend fun getMenuPromo(): List<PromoList> {
        return promoList
    }

    override suspend fun updateMenuPromo(): List<PromoList> {
        promoList.clear()
        promoList.add(PromoList(3, "https://images-dev.mygetplus.id/promotion/banners/Screenshot 2022-12-20 112945.png", 3, "https://getplus.onelink.me/wOe0/jz5q23kf?browser=true"))
        promoList.add(PromoList(4, "https://images-dev.mygetplus.id/promotion/banners/Screenshot 2022-12-20 112945.png", 4, "https://getplus.onelink.me/wOe0/jz5q23kf?browser=true"))
        return promoList
    }

}