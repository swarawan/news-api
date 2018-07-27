package com.swarawan.newsapi.deps

import com.swarawan.newsapi.NewsApiApp
import com.swarawan.newsapi.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by rioswarawan on 4/12/18.
 */

@Singleton
@Component(modules = [(NetworkingModule::class)])
interface DefaultComponent {

    fun inject(app: NewsApiApp)
    fun inject(activity: MainActivity)
}