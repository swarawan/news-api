package com.swarawan.newsapi.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.swarawan.newsapi.common.toDate
import com.swarawan.newsapi.model.Article
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * Created by Rio Swarawn on 7/27/18.
 */
class NewsViewHolder(itemView: View,
                     private val listener: NewsListener) : RecyclerView.ViewHolder(itemView) {

    fun bind(article: Article) {
        itemView.textTitle.text = article.title
        itemView.textDescription.text = article.description
        article.publishedAt?.let {
            itemView.textDate.text = it.toDate()
        }

        itemView.textAuthor.text = "Author: ${article.author}"

        Glide.with(itemView.context)
                .load(article.urlToImage)
                .into(itemView.imageNews)

        itemView.setOnClickListener { listener.onNewsClicked(article) }
    }

    interface NewsListener {
        fun onNewsClicked(article: Article)
    }
}