package com.swarawan.newsapi.ui.main

/**
 * Created by Rio Swarawn on 7/27/18.
 */
interface NewsPresenter {

    fun getAllNews(country: String, category: String, apiKey: String)
}