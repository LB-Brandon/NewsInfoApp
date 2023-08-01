package com.brandon.newsinfoapp.data.db

import androidx.room.Database
import androidx.room.TypeConverters
import com.brandon.newsinfoapp.data.model.Article


@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase {
    abstract fun getArticleDAO(): ArticleDAO
}