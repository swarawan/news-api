package com.swarawan.newsapi.model

/**
 * Created by Rio Swarawn on 7/27/18.
 */
data class NewsResponse(val status: String,
                        val totalResults: Int,
                        val articles: MutableList<Article>)