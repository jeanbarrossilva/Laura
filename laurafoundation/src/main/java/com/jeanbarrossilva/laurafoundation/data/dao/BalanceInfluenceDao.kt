package com.jeanbarrossilva.laurafoundation.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence

@Dao
interface BalanceInfluenceDao {
    @Query("SELECT * FROM influences")
    fun all(): LiveData<List<BalanceInfluence>>

    @Insert
    fun add(influence: BalanceInfluence)

    @Delete
    fun remove(influence: BalanceInfluence)
}