package com.test.headydemo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.test.headydemo.model.Categories
import com.test.headydemo.model.Rankings

/**
 * Created by Furqan on 04-01-2019.
 */
@Database(entities = arrayOf(Categories::class, Rankings::class), version = 1, exportSchema = false)
@TypeConverters(Convertors::class)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun rankingDao(): RankingDao
}