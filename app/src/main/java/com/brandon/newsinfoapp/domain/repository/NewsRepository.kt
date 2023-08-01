package com.brandon.newsinfoapp.domain.repository

import androidx.lifecycle.LiveData
import com.brandon.newsinfoapp.data.model.APIResponse
import com.brandon.newsinfoapp.data.model.Article
import com.brandon.newsinfoapp.data.util.Resource

import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    // getNewsHeadlines() is a suspend function that returns a Resource object with a generic type of APIResponse
    // will be implemented in NewsRepositoryImpl.kt
    suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse>
    suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse>

    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)

    // This function returns a Flow object with a generic type of List<Article>
    // so no need to use suspend keyword
    fun getSavedNews(): Flow<List<Article>>
}