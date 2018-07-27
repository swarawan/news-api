package com.swarawan.newsapi.ui.main

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.swarawan.newsapi.NewsApiApp
import com.swarawan.newsapi.R
import com.swarawan.newsapi.model.Article
import com.swarawan.newsapi.network.ServiceApi
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NewsViewHolder.NewsListener, NewsView {

    @Inject
    lateinit var serviceApi: ServiceApi

    private var newsAdapter: NewsAdapter? = null
    private val presenter: NewsPresenter by lazy {
        NewsPresenterImpl(serviceApi, this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as NewsApiApp).defaultComponent.inject(this@MainActivity)

        newsAdapter = NewsAdapter(mutableListOf(), this@MainActivity)
        recyclerViewNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        presenter.getAllNews("id", "technology", "b8b47644baea4122a20e792da43d5df7")
    }

    override fun onNewsClicked(article: Article) {
        article.url?.let {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(it)
            }
            startActivity(intent)
        }
    }

    override fun setProgressUpdates(visible: Boolean) {
        progressBar.visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun onNewsFetched(news: MutableList<Article>) {
        newsAdapter?.addNews(news)
    }

    override fun onError(message: String?) {
        message?.let {
            val dialogBuilder = AlertDialog.Builder(this).apply {
                setTitle(title)
                setMessage(message)
                setCancelable(false)
                setPositiveButton("Ya", null)
            }
            dialogBuilder.create().show()
        }
    }
}
