package com.jeanbarrossilva.laura.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jeanbarrossilva.laura.data.BalanceInfluence

@Dao
interface BalanceInfluenceDao {
    @Query("SELECT * FROM influences")
    fun all(): LiveData<List<BalanceInfluence>>

    @Query("SELECT * FROM influences WHERE id LIKE :id")
    fun identifiedAs(id: Long): BalanceInfluence

    @Update
    fun update(influence: BalanceInfluence)

    @Insert
    fun add(influence: BalanceInfluence)

    @Delete
    fun remove(influence: BalanceInfluence)
}