package com.test.headydemo.ui.product

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.headydemo.R
import com.test.headydemo.inflate
import com.test.headydemo.model.Variants
import kotlinx.android.synthetic.main.variant_dialog_item.view.*
import java.util.*

/**
 * Created by Furqan on 05-01-2019.
 */
class VarientAdapter(private val fragment: VarientDialogFragment, private val variants: ArrayList<Variants>) :
    RecyclerView.Adapter<VarientAdapter.VariantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VariantViewHolder {
        val view = parent.inflate(R.layout.variant_dialog_item)
        return VariantViewHolder(view)
    }

    override fun getItemCount(): Int = variants.size

    override fun onBindViewHolder(holder: VariantViewHolder, position: Int) {
        holder.bindVariant(variants[position])
    }

    inner class VariantViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        val view = v
        lateinit var variant: Variants

        init {
            view.setOnClickListener(this)
        }

        fun bindVariant(variant: Variants) {
            this.variant = variant
            view.txtPrice.text = "Price :${variant.price}"
            view.txtColor.text = "Color :${variant.color}"
            if (variant.size != 0) {
                view.txtSize.text = "Size : ${variant.size}"
            } else {
                view.txtSize.visibility = View.GONE
            }

        }


        override fun onClick(p: View?) {
// variant related functionality
        }


    }

}