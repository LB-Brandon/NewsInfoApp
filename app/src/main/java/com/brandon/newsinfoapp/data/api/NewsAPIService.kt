package com.brandon.newsinfoapp.data.api

import com.brandon.newsinfoapp.BuildConfig
import com.brandon.newsinfoapp.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query



interface NewsAPIService  {
    @GET("v2/top-headlines")
    suspend fun getNewsHeadlines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.NEWS_API_KEY
    ): Response<APIResponse>

    @GET("v2/top-headlines")
    suspend fun getSearchedNewsHeadlines(
        @Query("country")
        country: String,
        @Query("q")
        searchQuery: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.NEWS_API_KEY
    ): Response<APIResponse>

}