package com.prabudi.getapp.presentation.core

import com.prabudi.getapp.data.api.ApiService
import com.prabudi.getapp.repository.home.HomeRemoteDataSource
import com.prabudi.getapp.repository.home.HomeRemoteDataSourceImpl
import com.prabudi.getapp.repository.merchant.MerchantRemoteDataSource
import com.prabudi.getapp.repository.merchant.MerchantRemoteDataSourceImpl
import com.prabudi.getapp.repository.voucher.VoucherRemoteDataSource
import com.prabudi.getapp.repository.voucher.VoucherRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideHomeRemoteDataSource(apiService: ApiService): HomeRemoteDataSource {
        return HomeRemoteDataSourceImpl(
            apiService
        )
    }

    @Singleton
    @Provides
    fun provideMerchantRemoteDataSource(apiService: ApiService): MerchantRemoteDataSource {
        return MerchantRemoteDataSourceImpl(
            apiService
        )
    }

    @Singleton
    @Provides
    fun provideVoucherRemoteDataSource(apiService: ApiService): VoucherRemoteDataSource {
        return VoucherRemoteDataSourceImpl(
            apiService
        )
    }
}