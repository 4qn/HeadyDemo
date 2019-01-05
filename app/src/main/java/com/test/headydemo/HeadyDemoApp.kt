package com.test.headydemo

import android.app.Application
import androidx.room.Room
import com.test.headydemo.db.ProductDatabase

/**
 * Created by Furqan on 04-01-2019.
 */
class HeadyDemoApp : Application() {
    companion object {
        var database: ProductDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        HeadyDemoApp.database = Room.databaseBuilder(this, ProductDatabase::class.java, "product_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}