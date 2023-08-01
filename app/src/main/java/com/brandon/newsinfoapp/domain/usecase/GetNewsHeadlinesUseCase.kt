package com.brandon.newsinfoapp.domain.usecase

import com.brandon.newsinfoapp.data.model.APIResponse
import com.brandon.newsinfoapp.data.util.Resource
import com.brandon.newsinfoapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country : String, page : Int) : Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }
}