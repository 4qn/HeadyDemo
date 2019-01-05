package com.test.headydemo.ui.category

import com.test.headydemo.HeadyDemoApp
import com.test.headydemo.api.RequestApi
import com.test.headydemo.base.BaseMvpPresenterImpl
import com.test.headydemo.manager.ApiManager
import com.test.headydemo.model.HeadyResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Furqan on 03-01-2019.
 */
class MainPresenter : BaseMvpPresenterImpl<MainContract.View>(),
    MainContract.Presenter {

    /**
     * use to request api
     */
    override fun requestApi() {
        val requestApi: RequestApi = ApiManager.getClient(RequestApi::class.java)
        requestApi.fetchData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<HeadyResponse>() {
                override fun onComplete() {

                }

                override fun onNext(t: HeadyResponse) {
                    if (t.categories.isEmpty()) {
                        mView?.showMessage("No Data found")
                    } else {
                        mView?.showData(t.categories)
                    }
                    saveData(t)

                }

                override fun onError(e: Throwable) {

                }
            })

    }

    override fun saveData(t: HeadyResponse) {
        Single.fromCallable {
            HeadyDemoApp.database?.categoryDao()?.insertCategories(t.categories)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
        Single.fromCallable {
            HeadyDemoApp.database?.rankingDao()?.insertRankings(t.rankings)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

    }

    fun fetchFromDatabase() {
        HeadyDemoApp.database?.categoryDao()?.getAllCategory()!!.subscribeOn(
            Schedulers.io()
        ).observeOn(AndroidSchedulers.mainThread())
            .subscribe { cat ->
                if (cat.isEmpty()) {
                    mView?.showMessage("No Data found")
                } else
                    mView?.showData(cat)
            }
    }


}