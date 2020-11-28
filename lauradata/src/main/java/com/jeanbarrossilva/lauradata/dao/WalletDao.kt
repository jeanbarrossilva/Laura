package com.jeanbarrossilva.lauradata.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jeanbarrossilva.lauradata.Wallet

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