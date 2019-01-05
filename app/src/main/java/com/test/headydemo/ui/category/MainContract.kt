package com.test.headydemo.ui.category

import com.test.headydemo.base.BaseMvpPresenter
import com.test.headydemo.base.BaseMvpView
import com.test.headydemo.model.Categories
import com.test.headydemo.model.HeadyResponse

/**
 * Created by Furqan on 03-01-2019.
 */
object MainContract {

    interface View : BaseMvpView {
        fun showData(categories: List<Categories>)
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun requestApi()
        fun saveCategoryData(t: HeadyResponse)
    }
}