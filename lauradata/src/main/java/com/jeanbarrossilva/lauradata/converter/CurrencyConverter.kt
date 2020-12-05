package com.jeanbarrossilva.lauradata.converter

import com.jeanbarrossilva.lauradata.extension.CurrencyX.orderedCurrencies
import io.objectbox.converter.PropertyConverter
import java.util.*

class CurrencyConverter : PropertyConverter<Currency, String> {
	override fun convertToEntityProperty(databaseValue: String?) = orderedCurrencies.find { it.currencyCode == databaseValue }

	override fun convertToDatabaseValue(entityProperty: Currency?) = entityProperty?.currencyCode
}