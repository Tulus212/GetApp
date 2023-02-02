package com.prabudi.getapp.presentation.core

import com.prabudi.getapp.domain.home.HomeRepository
import com.prabudi.getapp.domain.merchants.MerchantRepository
import com.prabudi.getapp.domain.vouchers.VoucherRepository
import com.prabudi.getapp.repository.home.HomeCacheDataSource
import com.prabudi.getapp.repository.home.HomeRemoteDataSource
import com.prabudi.getapp.repository.home.HomeRepositoryImpl
import com.prabudi.getapp.repository.merchant.MerchantRemoteDataSource
import com.prabudi.getapp.repository.merchant.MerchantRepositoryImpl
import com.prabudi.getapp.repository.voucher.VoucherCacheDataSource
import com.prabudi.getapp.repository.voucher.VoucherRemoteDataSource
import com.prabudi.getapp.repository.voucher.VoucherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideHomeRepository(
        homeRemoteDatasource: HomeRemoteDataSource,
        homeCacheDataSource: HomeCacheDataSource
    ): HomeRepository {
        return HomeRepositoryImpl(
            homeRemoteDatasource,
            homeCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideMerchantRepository(
        merchantRemoteDataSource: MerchantRemoteDataSource
    ): MerchantRepository {
        return MerchantRepositoryImpl(
            merchantRemoteDataSource
        )
    }

    @Provides
    @Singleton
    fun provideVoucherRepository(
        voucherRemoteDataSource: VoucherRemoteDataSource,
        voucherCacheDataSource: VoucherCacheDataSource
    ): VoucherRepository {
        return VoucherRepositoryImpl(
            voucherRemoteDataSource,
            voucherCacheDataSource
        )
    }
}