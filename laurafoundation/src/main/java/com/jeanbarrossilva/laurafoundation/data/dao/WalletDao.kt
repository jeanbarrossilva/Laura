package com.jeanbarrossilva.laurafoundation.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jeanbarrossilva.laurafoundation.data.Wallet

@Dao
interface WalletDao {
    @Query("SELECT * FROM wallets")
    fun all(): LiveData<List<Wallet>>

    @Query("SELECT * FROM wallets WHERE id LIKE :id")
    fun identifiedAs(id: Long): Wallet

    @Update
    fun update(wallet: Wallet)

    @Insert
    fun add(wallet: Wallet)

    @Delete
    fun remove(wallet: Wallet)
}