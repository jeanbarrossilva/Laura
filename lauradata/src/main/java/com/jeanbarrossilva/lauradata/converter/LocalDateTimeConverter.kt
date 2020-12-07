package com.jeanbarrossilva.lauradata.converter

import com.jeanbarrossilva.lauradata.extension.NumberX.withDoubleDigit
import io.objectbox.converter.PropertyConverter
import java.time.LocalDateTime

class LocalDateTimeConverter : PropertyConverter<LocalDateTime, String> {
	override fun convertToEntityProperty(databaseValue: String?): LocalDateTime? {
		return databaseValue?.let {
			val (year, month, day) = with(it) { Triple(substring(0..3).toInt(), substring(5..6).toInt(), substring(8..9).toInt()) }
			val (hour, minute) = with(it) { substring(11..12).toInt() to substring(14..15).toInt() }

			LocalDateTime.of(year, month, day, hour, minute)
		}
	}

	override fun convertToDatabaseValue(entityProperty: LocalDateTime?): String? {
		return entityProperty?.run {
			"$year-${monthValue.withDoubleDigit}-${dayOfMonth.withDoubleDigit} ${hour.withDoubleDigit}:${minute.withDoubleDigit}"
		}
	}
}