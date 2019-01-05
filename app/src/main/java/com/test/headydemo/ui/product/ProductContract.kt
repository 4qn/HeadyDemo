package com.test.headydemo.ui.product

import com.test.headydemo.base.BaseMvpPresenter
import com.test.headydemo.base.BaseMvpView
import com.test.headydemo.model.Categories
import com.test.headydemo.model.HeadyResponse

/**
 * Created by Furqan on 05-01-2019.
 */
object ProductContract {

    interface View : BaseMvpView {
        fun showProduct(response: HeadyResponse)
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun fetchProductFromDb()

    }
}