package com.test.headydemo.helper

import com.test.headydemo.model.Products

/**
 * Created by Furqan on 05-01-2019.
 */
interface Filter {
    fun sortedBy(products: List<Products>,type:Int)
}