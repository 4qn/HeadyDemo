package com.test.headydemo.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<in V : BaseMvpView, T : BaseMvpPresenter<V>> : AppCompatActivity(), BaseMvpView {
    protected abstract var mPresenter: T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(view = this as V)
    }

    override fun showLoading() {
    }

    override fun hideLoading() {

    }


    override fun onError(resId: Int) {
    }

    override fun onError(message: String) {

    }

    override fun showMessage(message: String) {

    }

    override fun showMessage(resId: Int) {

    }

    override fun isNetworkConnected(): Boolean {
        return false
    }


    override fun getContext(): Context = this

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView();
    }

}
