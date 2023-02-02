package com.prabudi.getapp.presentation.core

import com.prabudi.getapp.domain.home.*
import com.prabudi.getapp.domain.merchants.GetMerchantUseCase
import com.prabudi.getapp.domain.merchants.MerchantRepository
import com.prabudi.getapp.domain.vouchers.GetVoucherUseCase
import com.prabudi.getapp.domain.vouchers.UpdateVoucherUseCase
import com.prabudi.getapp.domain.vouchers.VoucherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetMenuUseCase(homeRepository: HomeRepository):GetMenuUseCase{
        return GetMenuUseCase(homeRepository)
    }

    @Provides
    fun provideGetMenuPromoUseCase(homeRepository: HomeRepository):GetMenuPromoUseCase{
        return GetMenuPromoUseCase(homeRepository)
    }

    @Provides
    fun provideUpdateMenuUseCase(homeRepository: HomeRepository):UpdateMenuUseCase{
        return UpdateMenuUseCase(homeRepository)
    }

    @Provides
    fun provideUpdateMenuPromoUseCase(homeRepository: HomeRepository):UpdateMenuPromoUseCase{
        return UpdateMenuPromoUseCase(homeRepository)
    }

    @Provides
    fun provideGetMerchantUseCase(merchantRepository: MerchantRepository):GetMerchantUseCase{
        return GetMerchantUseCase(merchantRepository)
    }

    @Provides
    fun provideGetVoucherUseCase(voucherRepository: VoucherRepository):GetVoucherUseCase{
        return GetVoucherUseCase(voucherRepository)
    }

    @Provides
    fun provideUpdateVoucherUseCase(voucherRepository: VoucherRepository):UpdateVoucherUseCase{
        return UpdateVoucherUseCase(voucherRepository)
    }
}