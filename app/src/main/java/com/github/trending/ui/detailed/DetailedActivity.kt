package com.github.trending.ui.trending

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.github.trending.R
import com.github.trending.di.Screens
import com.github.trending.ui.trending.DetailedContract.Transitions.VIEW_NAME_DESCRIPTION
import com.github.trending.ui.trending.DetailedContract.Transitions.VIEW_NAME_IMAGE
import com.github.trending.ui.trending.DetailedContract.Transitions.VIEW_NAME_TITLE
import com.github.trending.ui.trending.TrendingContract.Arguments.EXTRA_ITEM
import com.github.trending.model.TrendingItem
import com.github.trending.utils.ext.argument
import com.github.trending.utils.ext.loadUrl
import kotlinx.android.synthetic.main.activity_detailed.image
import kotlinx.android.synthetic.main.activity_detailed.loading
import kotlinx.android.synthetic.main.activity_detailed.txtDescription
import kotlinx.android.synthetic.main.activity_detailed.txtFork
import kotlinx.android.synthetic.main.activity_detailed.txtIssues
import kotlinx.android.synthetic.main.activity_detailed.txtReadMe
import kotlinx.android.synthetic.main.activity_detailed.txtTitle
import kotlinx.android.synthetic.main.activity_detailed.txtWatch
import org.koin.android.ext.android.inject

class DetailedActivity: AppCompatActivity(), DetailedContract.View {

    override val presenter: DetailedContract.Presenter by inject { mapOf(Screens.TRENDING_DETAILED to this) }

    val item: TrendingItem by argument(EXTRA_ITEM)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        ViewCompat.setTransitionName(txtTitle, VIEW_NAME_TITLE)
        ViewCompat.setTransitionName(txtDescription, VIEW_NAME_DESCRIPTION)
        ViewCompat.setTransitionName(image, VIEW_NAME_IMAGE)

        presenter.getReadme(item.owner.login, item.name)

        txtTitle.text = item.title
        txtDescription.text = item.description
        image.loadUrl(item.owner.avatarUrl)
        txtWatch.text = item.watchersCount.toString()
        txtIssues.text = item.openIssuesCount.toString()
        txtFork.text = item.forksCount.toString()
    }

    override fun showReadMe(content: String) {
        txtReadMe.text = content
    }

    override fun showProgress() {
        loading.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        loading.visibility = View.GONE
    }

    override fun onReadMeFailed(ex: Throwable) {
    }
}