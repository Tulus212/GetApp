package com.prabudi.getapp.repository.home

import android.util.Log
import com.prabudi.getapp.data.model.home.Home
import com.prabudi.getapp.data.model.home.MenuList
import com.prabudi.getapp.data.model.home.PromoList
import com.prabudi.getapp.domain.home.HomeRepository
import retrofit2.Response

class HomeRepositoryImpl(
    private val homeRemoteDataSource: HomeRemoteDataSource,
    private val homeCacheDataSource: HomeCacheDataSource
) : HomeRepository {

    override suspend fun getMenu(): List<MenuList> {
        return getMenuFromCache()
    }

    override suspend fun updateMenu(): List<MenuList> {
        val newMenuList: List<MenuList> = getMenuFromAPI()
        homeCacheDataSource.saveHomeMenuFromCache(newMenuList)
        return newMenuList
    }

    override suspend fun getMenuPromo(): List<PromoList> {
        return getMenuPromoFromCache()
    }

    override suspend fun updateMenuPromo(): List<PromoList> {
        val newMenuPromoList: List<PromoList> = getMenuPromoFromAPI()
        homeCacheDataSource.saveHomeMenuPromoFromCache(newMenuPromoList)
        return newMenuPromoList
    }

    private suspend fun getMenuFromAPI():List<MenuList>{
        lateinit var menuList: List<MenuList>
        menuList = mutableListOf()
        try {
            val response : Response<Home> = homeRemoteDataSource.getHome()
            val body: Home? = response.body()
            if(body!=null){
                if(body.data?.layout?.menuLists?.size != 0) menuList = body.data?.layout?.menuLists!!
            }
        }catch (e: Exception){
            Log.i("TAG API", e.message.toString())
        }
        return menuList
    }

    private suspend fun getMenuFromCache():List<MenuList>{
        lateinit var menuList: List<MenuList>
        try {
            menuList = homeCacheDataSource.getHomeMenuFromCache()
        }catch (e: Exception){
            Log.i("TAG CACHE", e.message.toString())
        }
        if(menuList.isNotEmpty()){
            return menuList
        }else {
            menuList = getMenuFromAPI()
            homeCacheDataSource.saveHomeMenuFromCache(menuList)
        }
        return menuList
    }

    private suspend fun getMenuPromoFromAPI():List<PromoList>{
        lateinit var promoList: List<PromoList>
        promoList = mutableListOf()
        try {
            val response : Response<Home> = homeRemoteDataSource.getHome()
            val body: Home? = response.body()
            if(body!=null){
                if(body.data?.layout?.promo?.data?.isNotEmpty()!!) promoList = body.data.layout.promo.data
            }
        }catch (e: Exception){
            Log.i("TAG API", e.message.toString())
        }
        return promoList
    }

    private suspend fun getMenuPromoFromCache():List<PromoList>{
        lateinit var promoList: List<PromoList>
        try {
            promoList = homeCacheDataSource.getHomeMenuPromoFromCache()
        }catch (e: Exception){
            Log.i("TAG CACHE", e.message.toString())
        }
        if(promoList.isNotEmpty()){
            return promoList
        }else {
            promoList = getMenuPromoFromAPI()
            homeCacheDataSource.saveHomeMenuPromoFromCache(promoList)
        }
        return promoList
    }
}