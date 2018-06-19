package com.github.trending

import android.app.Application
import com.github.trending.di.app
import com.github.trending.di.networkModule
import org.koin.android.ext.android.startKoin

class GithubTrendingApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(app + networkModule)
    }
}