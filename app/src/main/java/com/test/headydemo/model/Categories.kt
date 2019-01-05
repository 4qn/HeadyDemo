package com.test.headydemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.ArrayList

/**
 * Created by Furqan on 03-01-2019.
 */
@Entity
data class Categories(
    @PrimaryKey val id: Int,
    val name: String,
    val products: List<Products>,
    val child_categories: ArrayList<Int>
)