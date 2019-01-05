package com.test.headydemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Furqan on 03-01-2019.
 */
@Entity
data class Rankings(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int,
    @PrimaryKey val ranking: String,
    val products: List<Products>
)