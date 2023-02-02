package com.prabudi.getapp.presentation.di.merchants

import com.prabudi.getapp.domain.merchants.GetMerchantUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class MerchantModule {
    @ActivityScoped
    @Provides
    fun provideVoucherViewModelFactory(
        getMerchantUseCase: GetMerchantUseCase
    ): MerchantViewModelFactory {
        return MerchantViewModelFactory(
            getMerchantUseCase
        )
    }
}