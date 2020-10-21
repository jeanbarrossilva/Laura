package com.jeanbarrossilva.laurafoundation.data.converter

import androidx.room.TypeConverter
import com.jeanbarrossilva.laurafoundation.LauraFoundation
import java.util.*

class CurrencyTypeConverter {
    @TypeConverter
    fun currencyToString(currency: Currency?): String? = currency?.currencyCode

    @TypeConverter
    fun stringToCurrency(string: String?) = LauraFoundation.currencies.find { string == it.currencyCode }
}