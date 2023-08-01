package com.brandon.newsinfoapp.data.repository.dataSource

import com.brandon.newsinfoapp.data.model.Article

interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
}