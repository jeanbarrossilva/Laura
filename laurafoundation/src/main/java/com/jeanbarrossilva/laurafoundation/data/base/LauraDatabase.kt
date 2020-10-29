package com.jeanbarrossilva.laurafoundation.data.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence
import com.jeanbarrossilva.laurafoundation.data.Wallet
import com.jeanbarrossilva.laurafoundation.data.converter.CurrencyTypeConverter
import com.jeanbarrossilva.laurafoundation.data.dao.BalanceInfluenceDao
import com.jeanbarrossilva.laurafoundation.data.dao.WalletDao

@Database(entities = [Wallet::class, BalanceInfluence::class], version = 7, exportSchema = false)
@TypeConverters(CurrencyTypeConverter::class)
abstract class LauraDatabase : RoomDatabase() {
    abstract fun walletDao(): WalletDao

    abstract fun balanceInfluenceDao(): BalanceInfluenceDao
}