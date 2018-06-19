package com.github.trending.ui.trending

import com.github.trending.ui.AbstractPresenter
import com.github.trending.utils.ext.toTrendingList
import com.github.trending.utils.ext.with
import com.github.trending.utils.rx.SchedulerProvider
import trending.github.com.data.repository.GithubRepository

class TrendingPresenter(private val repository: GithubRepository,
                        val scheduler: SchedulerProvider,
                        override var view: TrendingContract.View) :
        AbstractPresenter<TrendingContract.View, TrendingContract.Presenter>(),
        TrendingContract.Presenter {

    override fun getTrending(query: String, language: String) {
        view.showProgress()
        start {
            repository.getTrending(query, language)
                    .with(scheduler)
                    .subscribe(
                            {
                                view.hideProgress()
                                view.initTrending(it.toTrendingList())
                            }, {
                                view.hideProgress()
                                view.onTrendingFailed(it)
                            }
                    )
        }
    }
}