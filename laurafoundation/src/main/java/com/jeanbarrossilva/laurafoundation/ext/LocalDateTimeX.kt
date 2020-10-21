package com.jeanbarrossilva.laurafoundation.ext

import java.time.LocalDateTime

object LocalDateTimeX {
    val LocalDateTime.formatted get() = "$dayOfMonth/$monthValue/$year, $hour:$minute"

    infix fun LocalDateTime.isSameDayAs(otherDate: LocalDateTime) = dayOfYear == otherDate.dayOfYear
}