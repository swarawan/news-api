package com.swarawan.newsapi.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.swarawan.newsapi.R
import com.swarawan.newsapi.model.Article

/**
 * Created by Rio Swarawn on 7/27/18.
 */
class NewsAdapter(private val news: MutableList<Article>,
                  private val listener: NewsViewHolder.NewsListener) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view, listener)
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news[position])
    }

    fun addNews(news: MutableList<Article>) {
        this.news.addAll(news)
        this.notifyDataSetChanged()
    }
}