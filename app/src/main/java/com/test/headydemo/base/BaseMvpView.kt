package com.test.headydemo.base

import android.content.Context
import androidx.annotation.StringRes


/**
 * Created by Furqan on 03-01-2019.
 * @author Furqan
 * @version 1.0
 */
interface BaseMvpView {
    fun showLoading()

    fun hideLoading()

    fun onError(@StringRes resId: Int)

    fun onError(message: String)

    fun showMessage(message: String)

    fun showMessage(@StringRes resId: Int)

    fun isNetworkConnected(): Boolean

    fun getContext(): Context
}