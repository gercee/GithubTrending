package com.github.trending.ui

interface BasePresenter<T>{
    fun stop()
    var view: T
}