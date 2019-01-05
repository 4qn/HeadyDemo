package com.test.headydemo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.headydemo.model.Rankings
import io.reactivex.Flowable

/**
 * Created by Furqan on 04-01-2019.
 */
@Dao
interface RankingDao {

    @Query("SELECT * FROM Rankings")
    fun getAllProductRanking(): Flowable<List<Rankings>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRankings(categories: List<Rankings>)
}