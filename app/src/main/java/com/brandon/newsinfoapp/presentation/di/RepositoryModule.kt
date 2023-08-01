package com.brandon.newsinfoapp.presentation.di

import com.brandon.newsinfoapp.data.repository.NewsRepositoryImpl
import com.brandon.newsinfoapp.data.repository.dataSource.NewsRemoteDataSource
import com.brandon.newsinfoapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }



}