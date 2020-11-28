package com.jeanbarrossilva.lauradata.data.converter

import androidx.room.TypeConverter
import com.jeanbarrossilva.lauradata.extension.CurrencyX.orderedCurrencies
import java.util.*

class CurrencyTypeConverter {
    @TypeConverter
    fun currencyToString(currency: Currency?): String? = currency?.currencyCode

    @TypeConverter
    fun stringToCurrency(string: String?) = orderedCurrencies.find { string == it.currencyCode }
}