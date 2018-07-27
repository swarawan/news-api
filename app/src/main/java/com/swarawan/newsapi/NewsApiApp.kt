package com.swarawan.newsapi

import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.swarawan.newsapi.deps.DaggerDefaultComponent
import com.swarawan.newsapi.deps.DefaultComponent

/**
 * Created by Rio Swarawn on 7/27/18.
 */
class NewsApiApp : MultiDexApplication() {

    lateinit var defaultComponent: DefaultComponent

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        defaultComponent = DaggerDefaultComponent.create()
        defaultComponent.inject(this@NewsApiApp)
    }
}