package com.jeanbarrossilva.lauradata.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jeanbarrossilva.lauradata.data.converter.CurrencyTypeConverter
import com.jeanbarrossilva.lauradata.data.converter.LocalDateTimeTypeConverter
import com.jeanbarrossilva.lauradata.data.dao.BalanceInfluenceDao
import com.jeanbarrossilva.lauradata.BalanceInfluence
import com.jeanbarrossilva.lauradata.Wallet
import com.jeanbarrossilva.lauradata.data.dao.WalletDao

@Database(entities = [Wallet::class, BalanceInfluence::class], version = 1, exportSchema = false)
@TypeConverters(CurrencyTypeConverter::class, LocalDateTimeTypeConverter::class)
abstract class LauraDatabase : RoomDatabase() {
    abstract fun walletDao(): WalletDao

    abstract fun balanceInfluenceDao(): BalanceInfluenceDao
}