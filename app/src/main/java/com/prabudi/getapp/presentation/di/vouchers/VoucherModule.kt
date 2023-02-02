package com.prabudi.getapp.presentation.di.vouchers

import com.prabudi.getapp.domain.vouchers.GetVoucherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class VoucherModule {
    @ActivityScoped
    @Provides
    fun provideVoucherViewModelFactory(
        getVoucherUseCase: GetVoucherUseCase
    ): VoucherViewModelFactory {
        return VoucherViewModelFactory(
            getVoucherUseCase
        )
    }
}