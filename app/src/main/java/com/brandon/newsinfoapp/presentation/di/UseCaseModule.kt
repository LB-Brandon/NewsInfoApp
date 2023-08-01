package com.brandon.newsinfoapp.presentation.di

import com.brandon.newsinfoapp.domain.repository.NewsRepository
import com.brandon.newsinfoapp.domain.usecase.GetNewsHeadlinesUseCase
import com.brandon.newsinfoapp.domain.usecase.GetSearchedNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetNewsHeadLinesUseCase(
        newsRepository: NewsRepository
    ):GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSearchedNewsUseCase(
        newsRepository: NewsRepository
    ):GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(newsRepository)
    }
}