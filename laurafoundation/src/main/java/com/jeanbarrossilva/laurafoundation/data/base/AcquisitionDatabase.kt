package com.jeanbarrossilva.laurafoundation.data.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laurafoundation.data.converter.CurrencyTypeConverter
import com.jeanbarrossilva.laurafoundation.data.dao.AcquisitionDao

@Database(entities = [Acquisition::class], version = 1, exportSchema = false)
@TypeConverters(CurrencyTypeConverter::class)
abstract class AcquisitionDatabase : RoomDatabase() {
    abstract fun dao(): AcquisitionDao
}