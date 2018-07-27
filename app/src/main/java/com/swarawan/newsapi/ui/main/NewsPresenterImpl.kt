package com.swarawan.newsapi.ui.main

import com.swarawan.newsapi.model.NewsResponse
import com.swarawan.newsapi.network.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Rio Swarawn on 7/27/18.
 */
class NewsPresenterImpl(private val serviceApi: ServiceApi,
                        private val view: NewsView) : NewsPresenter {

    override fun getAllNews(country: String, category: String, apiKey: String) {

        view.setProgressUpdates(true)
        serviceApi.getTopHeadlines(country, category, apiKey)
                .enqueue(object : Callback<NewsResponse> {
                    override fun onFailure(call: Call<NewsResponse>?, t: Throwable?) {
                        view.setProgressUpdates(false)
                        view.onError(t?.localizedMessage)
                    }

                    override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                        view.setProgressUpdates(false)
                        if (response.isSuccessful) {
                            response.body()?.let {
                                view.onNewsFetched(it.articles)
                            }
                        }
                    }
                })
    }
}