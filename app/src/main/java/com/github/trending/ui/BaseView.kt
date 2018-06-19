package com.github.trending.ui

interface BaseView<out T:BasePresenter<*>>{
    val presenter: T
}