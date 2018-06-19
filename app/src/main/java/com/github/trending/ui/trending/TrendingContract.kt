package com.github.trending.ui.trending

import com.github.trending.ui.BasePresenter
import com.github.trending.ui.BaseView
import com.github.trending.model.TrendingItem

/**
 * Contract interface that holds the View and the Presenter interfaces.
 */
interface TrendingContract {
    object Arguments{
        const val EXTRA_ITEM = "EXTRA_ITEM"
    }
    interface View: BaseView<Presenter> {
        fun initTrending(result: List<TrendingItem>)
        fun showProgress()
        fun hideProgress()
        fun onTrendingFailed(error: Throwable)
    }

    interface Presenter: BasePresenter<View> {
        fun getTrending(query: String, language: String)
    }
}