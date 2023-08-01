package com.brandon.newsinfoapp.data.repository.dataSourceImpl

import com.brandon.newsinfoapp.data.db.ArticleDAO
import com.brandon.newsinfoapp.data.model.Article
import com.brandon.newsinfoapp.data.repository.dataSource.NewsLocalDataSource

class NewsLocalDataSourceImpl(
    private val articleDAO: ArticleDAO
) : NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDAO.insert(article)
    }
}