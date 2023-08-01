package com.brandon.newsinfoapp.data.repository.dataSourceImpl

import com.brandon.newsinfoapp.data.api.NewsAPIService
import com.brandon.newsinfoapp.data.model.APIResponse
import com.brandon.newsinfoapp.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country : String, page : Int): Response<APIResponse> {
        return newsAPIService.getNewsHeadlines(country, page)
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getSearchedNewsHeadlines(country, searchQuery, page)
    }
}