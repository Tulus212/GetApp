package com.prabudi.getapp.domain.home

import com.prabudi.getapp.data.model.home.PromoList

class GetMenuPromoUseCase(private val menuRepository: HomeRepository) {
    suspend fun execute():List<PromoList>? = menuRepository.getMenuPromo()
}