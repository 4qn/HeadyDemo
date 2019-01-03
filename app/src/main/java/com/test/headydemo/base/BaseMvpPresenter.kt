package com.test.headydemo.base

/**
 * Created by Furqan on 03-01-2019.
 */
interface BaseMvpPresenter<in V : BaseMvpView> {
    fun attachView(view: V)
    fun detachView()
}