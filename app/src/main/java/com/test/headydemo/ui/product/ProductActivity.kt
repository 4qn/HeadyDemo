package com.test.headydemo.ui.product

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.test.headydemo.R
import com.test.headydemo.base.BaseActivity
import com.test.headydemo.helper.Filter
import com.test.headydemo.model.HeadyResponse
import com.test.headydemo.model.Products
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : BaseActivity<ProductContract.View, ProductPresenter>(),
    ProductContract.View, Filter {
    override var mPresenter = ProductPresenter()
    lateinit var productList: List<Products>
    lateinit var adapter: ProductAdapter
    lateinit var newList: List<Products>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        productList = intent.getParcelableArrayListExtra(Intent.EXTRA_TEXT)

        val layoutManager = GridLayoutManager(this, 2)
        recyclerViewProduct.layoutManager = layoutManager
        recyclerViewProduct.setHasFixedSize(true)

        adapter = ProductAdapter(this, productList as ArrayList<Products>)
        recyclerViewProduct.adapter = adapter
        btnFilter.setOnClickListener { showFilterDialog() }

    }

    private fun showFilterDialog() {
        val filterDialogFragment = FilterDialogFragment.newInstance(this)
        filterDialogFragment.show(supportFragmentManager, filterDialogFragment.tag)
    }

    override fun showProduct(response: HeadyResponse) {

    }

    override fun sortedBy(products: List<Products>, type: Int) {
        val filterdList = ArrayList<Products>()
        productList.forEachIndexed { index, product ->
            val existProduct = products.find { it.id == product.id }

            if (existProduct != null) {

                product.view_count = existProduct?.view_count!!
                product.order_count = existProduct.order_count
                product.shares = existProduct.shares
            } else {
                product.view_count = 0
                product.order_count = 0
                product.shares = 0

            }
            filterdList.add(
                Products(
                    product.id, product.name, product.date_added, product.variants,
                    product.tax, product.view_count, product.order_count, product.shares
                )
            )
        }

        when (type) {
            // Most viewed
            0 -> {

                newList = filterdList.sortedWith(compareBy { it.view_count })
            }
            // Most Orderd
            1 -> {
                newList = filterdList.sortedWith(compareBy { it.order_count })

            }
            // Most Shared
            2 -> {
                filterdList.sortedWith(compareBy { it.shares })
            }
            else -> {
                newList = ArrayList<Products>()
            }
        }
        adapter.filter(newList)
    }
}
