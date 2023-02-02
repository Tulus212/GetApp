package com.prabudi.getapp.domain.home

import com.prabudi.getapp.data.model.home.PromoList

class UpdateMenuPromoUseCase(private val menuRepository: HomeRepository) {
    suspend fun execute():List<PromoList>? = menuRepository.updateMenuPromo()
}