package com.jeanbarrossilva.lauradata.data.converter

import androidx.room.TypeConverter
import com.jeanbarrossilva.lauradata.extension.LocalDateTimeX.formatted
import com.jeanbarrossilva.lauradata.extension.StringX.toLocalDateTime
import java.time.LocalDateTime

class LocalDateTimeTypeConverter {
    @TypeConverter
    fun localDateTimeToString(localDateTime: LocalDateTime) = localDateTime.formatted

    @TypeConverter
    fun stringToLocalDatetime(string: String) = string.toLocalDateTime()
}