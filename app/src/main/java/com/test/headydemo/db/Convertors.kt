package com.test.headydemo.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.test.headydemo.model.Products
import java.util.ArrayList

/**
 * Created by Furqan on 04-01-2019.
 */
class Convertors {
    @TypeConverter
    fun fromProduct(products: String): List<Products> {
        val listType = object : TypeToken<ArrayList<Products>>() {

        }.type
        return Gson().fromJson<ArrayList<Products>>(products, listType)
    }


    @TypeConverter
    fun productToString(products: List<Products>): String {
        return Gson().toJson(products)
    }

    @TypeConverter
    fun fromSubCat(subCat: String): ArrayList<Int> {
        val listType = object : TypeToken<ArrayList<Int>>() {

        }.type
        return Gson().fromJson<ArrayList<Int>>(subCat, listType)
    }
    @TypeConverter
    fun subCatToString(subCat:ArrayList<Int>): String {
        return Gson().toJson(subCat)
    }
}