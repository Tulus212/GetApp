package com.prabudi.getapp.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.prabudi.getapp.data.model.home.MenuList
import com.prabudi.getapp.data.model.home.PromoList
import com.prabudi.getapp.domain.home.GetMenuPromoUseCase
import com.prabudi.getapp.domain.home.GetMenuUseCase
import com.prabudi.getapp.domain.home.UpdateMenuPromoUseCase
import com.prabudi.getapp.domain.home.UpdateMenuUseCase
import com.prabudi.getapp.getOrAwaitValue
import com.prabudi.getapp.presentation.di.home.HomeViewModel
import com.prabudi.getapp.repository.FakeHomeRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
      val fakeHomeRepository = FakeHomeRepository()
      val getMenuUsecase = GetMenuUseCase(fakeHomeRepository)
      val getMenuPromoUsecase = GetMenuPromoUseCase(fakeHomeRepository)
      val updateMenuUsecase = UpdateMenuUseCase(fakeHomeRepository)
      val updateMenuPromoUsecase = UpdateMenuPromoUseCase(fakeHomeRepository)
      viewModel = HomeViewModel(getMenuUsecase,getMenuPromoUsecase,updateMenuUsecase,updateMenuPromoUsecase)
    }

    @Test
    fun getMenu_returnsCurrentList(){
        val menuList = mutableListOf<MenuList>()
        menuList.add(MenuList("1", "overview1", true, "test", "https://firebasestorage.googleapis.com/v0/b/getplus-46d55.appspot.com/o/home_layout%2FicoShop%403x.png?alt=media&token=d40fed97-0165-4afa-bcfb-22786ecd4066", true))
        menuList.add(MenuList("2", "overview2", true, "date2", "https://firebasestorage.googleapis.com/v0/b/getplus-46d55.appspot.com/o/home_layout%2FicoShop%403x.png?alt=media&token=d40fed97-0165-4afa-bcfb-22786ecd4066", true))

        val currentList = viewModel.getMenu().getOrAwaitValue()
        assertThat(currentList).isEqualTo(menuList)
    }

    @Test
    fun updateMenu_returnsUpdatedList(){
        val menuList = mutableListOf<MenuList>()
        menuList.add(MenuList("3", "overview1", true, "test", "https://firebasestorage.googleapis.com/v0/b/getplus-46d55.appspot.com/o/home_layout%2FicoShop%403x.png?alt=media&token=d40fed97-0165-4afa-bcfb-22786ecd4066", true))
        menuList.add(MenuList("4", "overview2", true, "date2", "https://firebasestorage.googleapis.com/v0/b/getplus-46d55.appspot.com/o/home_layout%2FicoShop%403x.png?alt=media&token=d40fed97-0165-4afa-bcfb-22786ecd4066", true))

        val updatedList = viewModel.updateMenu().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(menuList)
    }

    @Test
    fun getMenuPromo_returnsCurrentList(){
        val promoList = mutableListOf<PromoList>()
        promoList.add(PromoList(1, "https://images-dev.mygetplus.id/promotion/banners/Screenshot 2022-12-20 112945.png", 1, "https://getplus.onelink.me/wOe0/jz5q23kf?browser=true"))
        promoList.add(PromoList(2, "https://images-dev.mygetplus.id/promotion/banners/Screenshot 2022-12-20 112945.png", 2, "https://getplus.onelink.me/wOe0/jz5q23kf?browser=true"))

        val currentList = viewModel.getMenuPromo().getOrAwaitValue()
        assertThat(currentList).isEqualTo(promoList)
    }

    @Test
    fun updateMenuPromo_returnsUpdatedList(){
        val promoList = mutableListOf<PromoList>()
        promoList.add(PromoList(3, "https://images-dev.mygetplus.id/promotion/banners/Screenshot 2022-12-20 112945.png", 3, "https://getplus.onelink.me/wOe0/jz5q23kf?browser=true"))
        promoList.add(PromoList(4, "https://images-dev.mygetplus.id/promotion/banners/Screenshot 2022-12-20 112945.png", 4, "https://getplus.onelink.me/wOe0/jz5q23kf?browser=true"))

        val updatedList = viewModel.updateMenuPromo().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(promoList)
    }
}









