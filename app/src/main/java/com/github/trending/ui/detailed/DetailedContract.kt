package com.github.trending.ui.trending

import com.github.trending.ui.BasePresenter
import com.github.trending.ui.BaseView

/**
 * Contract interface that holds the View and the Presenter interfaces.
 */
interface DetailedContract {
    object Transitions{
        const val VIEW_NAME_IMAGE = "detail:header:image"
        const val VIEW_NAME_TITLE = "detail:header:title"
        const val VIEW_NAME_DESCRIPTION = "detail:header:description"
    }
    interface View: BaseView<Presenter> {
        fun showReadMe(content: String)
        fun showProgress()
        fun hideProgress()
        fun onReadMeFailed(ex: Throwable)
    }

    interface Presenter: BasePresenter<View> {
        fun getReadme(owner: String, repo: String)
    }
}