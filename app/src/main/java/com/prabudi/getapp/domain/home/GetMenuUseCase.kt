package com.prabudi.getapp.domain.home

import com.prabudi.getapp.data.model.home.MenuList

class GetMenuUseCase(private val menuRepository: HomeRepository) {
    suspend fun execute():List<MenuList>? = menuRepository.getMenu()
}