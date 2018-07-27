package com.swarawan.newsapi.ui.main

import com.swarawan.newsapi.model.Article

/**
 * Created by Rio Swarawn on 7/27/18.
 */
interface NewsView {

    fun setProgressUpdates(visible: Boolean)

    fun onNewsFetched(news: MutableList<Article>)

    fun onError(message: String?)
}