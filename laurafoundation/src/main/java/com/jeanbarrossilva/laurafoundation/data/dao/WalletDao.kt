package com.jeanbarrossilva.laurafoundation.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jeanbarrossilva.laurafoundation.data.Wallet

@Dao
interface WalletDao {
    @Query("SELECT * FROM wallets")
    fun all(): LiveData<List<Wallet>>

    @Query("SELECT * FROM wallets WHERE uuid LIKE :uuid")
    fun identifiedAs(uuid: String): Wallet

    @Insert
    fun add(wallet: Wallet)

    @Delete
    fun remove(wallet: Wallet)
}