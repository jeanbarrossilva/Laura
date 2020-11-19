package com.jeanbarrossilva.laura.data.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jeanbarrossilva.laura.data.BalanceInfluence
import com.jeanbarrossilva.laura.data.Wallet
import com.jeanbarrossilva.laura.data.converter.CurrencyTypeConverter
import com.jeanbarrossilva.laura.data.converter.LocalDateTimeTypeConverter
import com.jeanbarrossilva.laura.data.dao.BalanceInfluenceDao
import com.jeanbarrossilva.laura.data.dao.WalletDao

@Database(entities = [Wallet::class, BalanceInfluence::class], version = 11, exportSchema = false)
@TypeConverters(CurrencyTypeConverter::class, LocalDateTimeTypeConverter::class)
abstract class LauraDatabase : RoomDatabase() {
    abstract fun walletDao(): WalletDao

    abstract fun balanceInfluenceDao(): BalanceInfluenceDao
}