package com.test.headydemo.ui

import com.test.headydemo.base.BaseMvpPresenter
import com.test.headydemo.base.BaseMvpView

/**
 * Created by Furqan on 03-01-2019.
 */
object MainContract {

    interface View : BaseMvpView {

    }

    interface Presenter : BaseMvpPresenter<View> {

    }
}