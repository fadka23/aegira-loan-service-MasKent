package com.blas.creditappdemo.di

import com.blas.creditappdemo.data.repository.KreditRepositoryImpl
import com.blas.creditappdemo.domain.repository.KreditRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindKreditRepository(
        kreditRepositoryImpl: KreditRepositoryImpl
    ): KreditRepository
}