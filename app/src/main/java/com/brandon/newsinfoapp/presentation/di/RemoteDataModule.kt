package com.brandon.newsinfoapp.presentation.di

import com.brandon.newsinfoapp.data.api.NewsAPIService
import com.brandon.newsinfoapp.data.repository.dataSource.NewsRemoteDataSource
import com.brandon.newsinfoapp.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
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
    fun provideNewsRemoteDataSource(
        newsAPIService: NewsAPIService
    ): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}