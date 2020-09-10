package com.jeanbarrossilva.laurafoundation.ext

import java.time.LocalDateTime

object LocalDateTimeX {
    infix fun LocalDateTime.isSameDayAs(otherDate: LocalDateTime) = dayOfYear == otherDate.dayOfYear
}