package com.brandon.newsinfoapp.domain.usecase

import com.brandon.newsinfoapp.data.model.Article
import com.brandon.newsinfoapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository){
    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}