package com.test.headydemo.ui.category

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.test.headydemo.R
import com.test.headydemo.base.BaseActivity
import com.test.headydemo.model.Categories
import com.test.headydemo.utils.NetworkUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainContract.View, MainPresenter>(),
    MainContract.View {


    override var mPresenter = MainPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // check device is connected to internet

        if (NetworkUtils.isConnected(this)) {
            mPresenter.requestApi()
        } else {
            mPresenter.fetchFromDatabase()
        }

    }

    override fun showData(categories: List<Categories>) {
        progressBar.visibility = View.GONE
        val layoutManager = GridLayoutManager(this, 2)
        recyclerViewCategory.layoutManager = layoutManager
        recyclerViewCategory.setHasFixedSize(true)
        val parentCat = categories.filter { it.child_categories.size > 0 }
        if (parentCat.isNotEmpty()) {
            val adapter = CategoryAdapter(this, parentCat)
            recyclerViewCategory.adapter = adapter
        }
    }

    override fun showMessage(message: String) {
        super.showMessage(message)
        progressBar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
