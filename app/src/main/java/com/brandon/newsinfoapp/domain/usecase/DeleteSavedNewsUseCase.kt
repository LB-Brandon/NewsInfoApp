package com.brandon.newsinfoapp.domain.usecase

import com.brandon.newsinfoapp.data.model.Article
import com.brandon.newsinfoapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}
