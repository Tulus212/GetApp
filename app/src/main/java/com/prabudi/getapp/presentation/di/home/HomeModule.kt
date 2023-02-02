package com.prabudi.getapp.presentation.di.home

import com.prabudi.getapp.domain.home.GetMenuPromoUseCase
import com.prabudi.getapp.domain.home.GetMenuUseCase
import com.prabudi.getapp.domain.home.UpdateMenuPromoUseCase
import com.prabudi.getapp.domain.home.UpdateMenuUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class HomeModule {
    @ActivityScoped
    @Provides
    fun provideHomeViewModelFactory(
        getMenuUseCase: GetMenuUseCase,
        getMenuPromoUseCase: GetMenuPromoUseCase,
        updateMenuUseCase: UpdateMenuUseCase,
        updateMenuPromoUseCase: UpdateMenuPromoUseCase
    ): HomeViewModelFactory {
        return HomeViewModelFactory(
            getMenuUseCase,
            getMenuPromoUseCase,
            updateMenuUseCase,
            updateMenuPromoUseCase
        )
    }
}