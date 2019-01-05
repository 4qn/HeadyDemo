package com.test.headydemo.utils

import androidx.recyclerview.widget.DiffUtil
import com.test.headydemo.model.Products

/**
 * Created by Furqan on 22-03-2018.
 */
class ProductDiffUtilCallback(val oldList: List<Products>, val newList: List<Products>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList[newItemPosition].id == oldList[oldItemPosition].id
    }

    override fun getOldListSize() = oldList.size


    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList[newItemPosition] == oldList[oldItemPosition]
    }

}