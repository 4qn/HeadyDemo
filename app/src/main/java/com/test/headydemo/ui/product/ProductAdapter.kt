package com.test.headydemo.ui.product

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.headydemo.R
import com.test.headydemo.inflate
import com.test.headydemo.model.Products
import com.test.headydemo.model.Variants
import com.test.headydemo.utils.ProductDiffUtilCallback
import kotlinx.android.synthetic.main.item_product.view.*
import java.util.*

/**
 * Created by Furqan on 03-01-2019.
 */
class ProductAdapter(private val activity: ProductActivity, private val products: ArrayList<Products>) :
    RecyclerView.Adapter<ProductAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = parent.inflate(R.layout.item_product)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindProduct(products[position])
    }

    fun filter(products: List<Products>) {
        val diffResult = DiffUtil.calculateDiff(ProductDiffUtilCallback(this.products, products))
        this.products.clear()
        this.products.addAll(products)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class CategoryViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        val view = v
        lateinit var product: Products

        init {
            view.setOnClickListener(this)
        }

        fun bindProduct(product: Products) {
            this.product = product
            view.layoutProduct.setBackgroundColor(pickRandomColor())
            view.txtPrdName.text = product.name
            if (product.variants.isNotEmpty()) {
                view.txtPrice.text = "Rs: ${product.variants[0].price}"
                if (product.variants[0].size != 0) {
                    view.txtSize.text = "Size: ${product.variants[0].size}"
                } else {
                    view.txtSize.text = "Color: ${product.variants[0].color}"
                }
            }
        }

        private fun pickRandomColor(): Int {
            val random = Random()
            return Color.rgb(
                random.nextInt(256), random.nextInt(256),
                random.nextInt(256)
            )
        }

        override fun onClick(p: View?) {
            showSubCat(product.variants)
        }

        private fun showSubCat(variants: List<Variants>) {
            val varientDialogFragment =
                VarientDialogFragment.newInstance(variants as ArrayList<Variants>)
            varientDialogFragment.show(activity.supportFragmentManager, varientDialogFragment.tag)
        }
    }
}