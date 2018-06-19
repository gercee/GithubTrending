package com.github.trending.ui

import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * Abstract Presenter for lunching Rx Jobs.
 */
abstract class AbstractPresenter<V : BaseView<P>, out P: BasePresenter<V>>: BasePresenter<V> {

    override lateinit var view: V

    val disposables = CompositeDisposable()

    fun start(job: () -> Disposable) {
        disposables.add(job())
    }

    @CallSuper
    override fun stop() {
        disposables.clear()
    }
}