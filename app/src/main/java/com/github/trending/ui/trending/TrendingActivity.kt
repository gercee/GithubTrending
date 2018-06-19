package com.github.trending.ui.trending

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.github.trending.R
import com.github.trending.di.Screens
import com.github.trending.ui.trending.TrendingContract.Arguments.EXTRA_ITEM
import com.github.trending.ui.trending.list.TrendingAdapter
import com.github.trending.model.TrendingItem
import kotlinx.android.synthetic.main.activity_main.loading
import kotlinx.android.synthetic.main.activity_main.trendingList
import org.koin.android.ext.android.inject
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import com.github.trending.ui.trending.DetailedContract.Transitions.VIEW_NAME_DESCRIPTION
import com.github.trending.ui.trending.DetailedContract.Transitions.VIEW_NAME_IMAGE
import com.github.trending.ui.trending.DetailedContract.Transitions.VIEW_NAME_TITLE
import com.github.trending.ui.trending.list.ItemListener
import kotlinx.android.synthetic.main.item_trending.view.description
import kotlinx.android.synthetic.main.item_trending.view.image
import kotlinx.android.synthetic.main.item_trending.view.title


class TrendingActivity : AppCompatActivity(), TrendingContract.View, ItemListener {

    companion object {
        private val LOG_TAG = TrendingActivity::class.simpleName
    }

    override val presenter: TrendingContract.Presenter by inject { mapOf(Screens.TRENDING_LIST to this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trendingList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        presenter.getTrending("android", "kotlin")
    }

    override fun initTrending(result: List<TrendingItem>) {
        val adapter = TrendingAdapter(this, result)
        trendingList.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onItemClicked(item: TrendingItem, view: View) {
        val pair1 = Pair<View, String>(view.title, VIEW_NAME_TITLE)
        val pair2 = Pair<View, String>(view.image, VIEW_NAME_IMAGE)
        val pair3 = Pair<View, String>(view.description, VIEW_NAME_DESCRIPTION)

        val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pair1, pair2, pair3)
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra(EXTRA_ITEM, item)
        ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
    }

    /**
     * Show the progress animation.
     */
    override fun showProgress() {
        loading.visibility = View.VISIBLE
    }

    /**
     * Hide the progress animation.
     */
    override fun hideProgress() {
        loading.visibility = View.GONE
    }

    /**
     * Handle the failure of the trending request.
     */
    override fun onTrendingFailed(error: Throwable) {
        Log.e(LOG_TAG, "onTrendingFailed", error)
    }
}