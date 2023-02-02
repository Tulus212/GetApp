package com.prabudi.getapp.presentation.core

import com.prabudi.getapp.repository.home.HomeCacheDataSource
import com.prabudi.getapp.repository.home.HomeCacheDataSourceImp
import com.prabudi.getapp.repository.merchant.MerchantCacheDataSource
import com.prabudi.getapp.repository.merchant.MerchantCacheDataSourceImpl
import com.prabudi.getapp.repository.voucher.VoucherCacheDataSource
import com.prabudi.getapp.repository.voucher.VoucherCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {
    @Singleton
    @Provides
    fun provideHomeCacheDataSource(): HomeCacheDataSource {
        return HomeCacheDataSourceImp()
    }

    @Singleton
    @Provides
    fun provideMerchantCacheDataSource(): MerchantCacheDataSource {
        return MerchantCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideVoucherCacheDataSource(): VoucherCacheDataSource {
        return VoucherCacheDataSourceImpl()
    }
}