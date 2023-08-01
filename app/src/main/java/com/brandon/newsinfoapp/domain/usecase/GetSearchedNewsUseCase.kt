package com.brandon.newsinfoapp.domain.usecase

import com.brandon.newsinfoapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String, searchQuery: String, page: Int) =
        newsRepository.getSearchedNews(country, searchQuery, page)
}