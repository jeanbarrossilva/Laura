package com.jeanbarrossilva.laurafoundation.data.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laurafoundation.data.Wallet
import com.jeanbarrossilva.laurafoundation.data.converter.CurrencyTypeConverter
import com.jeanbarrossilva.laurafoundation.data.dao.AcquisitionDao
import com.jeanbarrossilva.laurafoundation.data.dao.WalletDao

@Database(entities = [Wallet::class, Acquisition::class], version = 2, exportSchema = false)
@TypeConverters(CurrencyTypeConverter::class)
abstract class LauraDatabase : RoomDatabase() {
    abstract fun walletDao(): WalletDao
    abstract fun acquisitionDao(): AcquisitionDao
}