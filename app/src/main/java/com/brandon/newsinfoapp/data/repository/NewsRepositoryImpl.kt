package com.brandon.newsinfoapp.data.repository

import com.brandon.newsinfoapp.data.model.APIResponse
import com.brandon.newsinfoapp.data.model.Article
import com.brandon.newsinfoapp.data.repository.dataSource.NewsLocalDataSource
import com.brandon.newsinfoapp.data.repository.dataSource.NewsRemoteDataSource
import com.brandon.newsinfoapp.data.util.Resource
import com.brandon.newsinfoapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

// Connection between domain and data layer
class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {

    // check if the response is successful
    private fun responseToResource(response: Response<APIResponse>)
    : Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getNewsHeadlines(country : String, page : Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country, page))
    }


    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getSearchedNews(country, searchQuery, page))
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}