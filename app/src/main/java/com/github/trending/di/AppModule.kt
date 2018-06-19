package com.github.trending.di

import com.github.trending.di.Screens.TRENDING_DETAILED
import com.github.trending.di.Screens.TRENDING_LIST
import trending.github.com.data.repository.GithubRepository
import trending.github.com.data.repository.GithubRepositoryImpl
import com.github.trending.ui.trending.DetailedContract
import com.github.trending.ui.trending.DetailedPresenter
import com.github.trending.ui.trending.TrendingContract
import com.github.trending.ui.trending.TrendingPresenter
import com.github.trending.utils.rx.ApplicationSchedulerProvider
import com.github.trending.utils.rx.SchedulerProvider
import org.koin.dsl.module.applicationContext

val appModule = applicationContext {

    factory { params -> TrendingPresenter(get(), get(), params[TRENDING_LIST]) as TrendingContract.Presenter }

    factory { params -> DetailedPresenter(get(), get(), params[TRENDING_DETAILED]) as DetailedContract.Presenter }

    bean { GithubRepositoryImpl(get()) as GithubRepository}
}

val rxModule = applicationContext {
    bean { ApplicationSchedulerProvider() as SchedulerProvider }
}

val app = listOf(appModule, rxModule)

object Screens {
    const val TRENDING_LIST = "TRENDING_LIST"
    const val TRENDING_DETAILED = "TRENDING_DETAILED"
}