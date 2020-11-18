package com.jeanbarrossilva.laurafoundation.data.converter

import androidx.room.TypeConverter
import com.jeanbarrossilva.laura.extension.LocalDateTimeX.formatted
import com.jeanbarrossilva.laura.extension.StringX.toLocalDateTime
import java.time.LocalDateTime

class LocalDateTimeTypeConverter {
    @TypeConverter
    fun localDateTimeToString(localDateTime: LocalDateTime) = localDateTime.formatted

    @TypeConverter
    fun stringToLocalDatetime(string: String) = string.toLocalDateTime()
}