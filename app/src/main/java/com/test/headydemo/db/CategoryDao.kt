package com.test.headydemo.db

import androidx.room.*
import com.test.headydemo.model.Categories
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Furqan on 04-01-2019.
 */
@Dao
interface CategoryDao {
    @Query("SELECT * FROM Categories")
    fun getAllCategory(): Flowable<List<Categories>>

    @Query("select * from Categories where id = :id")
    fun getCategoryById(id: Int): Single<Categories>

    @Query("select * from Categories where id in (:ids)")
    fun getSubCategories(ids: List<Int>): Flowable<List<Categories>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Categories)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(categories: List<Categories>)
}