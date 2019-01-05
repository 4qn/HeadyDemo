package com.test.headydemo.ui.product

import com.test.headydemo.HeadyDemoApp
import com.test.headydemo.api.RequestApi
import com.test.headydemo.base.BaseMvpPresenterImpl
import com.test.headydemo.manager.ApiManager
import com.test.headydemo.model.Categories
import com.test.headydemo.model.HeadyResponse
import com.test.headydemo.ui.category.MainContract
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Furqan on 05-01-2019.
 */
class ProductPresenter : BaseMvpPresenterImpl<ProductContract.View>(),
    ProductContract.Presenter {

    override fun fetchProductFromDb() {

    }
}