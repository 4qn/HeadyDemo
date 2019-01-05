package com.test.headydemo.ui.product

import com.test.headydemo.base.BaseMvpPresenterImpl

/**
 * Created by Furqan on 05-01-2019.
 */
class ProductPresenter : BaseMvpPresenterImpl<ProductContract.View>(),
    ProductContract.Presenter {

    override fun fetchProductFromDb() {

    }
}