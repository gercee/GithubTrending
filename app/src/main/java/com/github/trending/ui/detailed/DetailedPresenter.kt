package com.github.trending.ui.trending

import android.util.Base64
import com.github.trending.ui.AbstractPresenter
import com.github.trending.utils.ext.with
import com.github.trending.utils.rx.SchedulerProvider
import trending.github.com.data.repository.GithubRepository
import java.nio.charset.StandardCharsets

class DetailedPresenter(private val repository: GithubRepository,
                        val scheduler: SchedulerProvider,
                        override var view: DetailedContract.View) :
        AbstractPresenter<DetailedContract.View, DetailedContract.Presenter>(),
        DetailedContract.Presenter {

    override fun getReadme(owner: String, repo: String) {
        view.showProgress()
        start {
            repository.getReadme(owner, repo)
                    .with(scheduler)
                    .subscribe(
                            {
                                view.hideProgress()
                                val data = Base64.decode(it.content, Base64.DEFAULT)
                                val content = String(data, StandardCharsets.UTF_8)
                                view.showReadMe(content)
                            }, {
                                view.hideProgress()
                                view.onReadMeFailed(it)
                            }
                    )
        }
    }
}