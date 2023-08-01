package com.brandon.newsinfoapp.presentation.di

import android.app.Application
import com.brandon.newsinfoapp.domain.usecase.GetNewsHeadlinesUseCase
import com.brandon.newsinfoapp.domain.usecase.GetSearchedNewsUseCase
import com.brandon.newsinfoapp.domain.usecase.SaveNewsUseCase
import com.brandon.newsinfoapp.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


// This module is for implementing the NewsViewModelFactory class
@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        app: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase
        )
    }

}