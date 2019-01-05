package com.test.headydemo.ui.category

import android.content.Intent
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.test.headydemo.R
import com.test.headydemo.inflate
import com.test.headydemo.model.Categories
import com.test.headydemo.model.Products
import com.test.headydemo.ui.product.ProductActivity
import kotlinx.android.synthetic.main.fragment_subcat_dialog_item.view.*
import kotlin.collections.ArrayList

/**
 * Created by Furqan on 05-01-2019.
 */
class SubCatAdapter(private val fragment: SubCatDialogFragment, private val categories: List<Categories>) :
    RecyclerView.Adapter<SubCatAdapter.SubCatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCatViewHolder {
        val view = parent.inflate(R.layout.fragment_subcat_dialog_item)
        return SubCatViewHolder(view)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: SubCatViewHolder, position: Int) {
        holder.bindCategory(categories[position])
    }

    inner class SubCatViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        val view = v
        lateinit var category: Categories

        init {
            view.setOnClickListener(this)
        }

        fun bindCategory(category: Categories) {
            this.category = category
            view.txtSubCat.text = category.name

        }


        override fun onClick(p: View?) {
            if (category.products.isNotEmpty()) {
                val intent = Intent(view.context, ProductActivity::class.java)
                intent.putParcelableArrayListExtra(
                    Intent.EXTRA_TEXT,
                    category.products as ArrayList<Products>
                )

                fragment.startActivity(intent)
                fragment.dismiss()

            } else {
                Toast.makeText(view.context, "No product Found", Toast.LENGTH_LONG).show()
            }
        }

    }

}