package com.brandon.newsinfoapp.domain.usecase


import com.brandon.newsinfoapp.data.model.Article
import com.brandon.newsinfoapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow


class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}