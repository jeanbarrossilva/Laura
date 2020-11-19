package com.jeanbarrossilva.laura.data.converter

import androidx.room.TypeConverter
import com.jeanbarrossilva.laura.extension.CurrencyX.orderedCurrencies
import java.util.*

class CurrencyTypeConverter {
    @TypeConverter
    fun currencyToString(currency: Currency?): String? = currency?.currencyCode

    @TypeConverter
    fun stringToCurrency(string: String?) = orderedCurrencies.find { string == it.currencyCode }
}