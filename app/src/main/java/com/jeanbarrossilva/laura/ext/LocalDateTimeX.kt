package com.jeanbarrossilva.laura.ext

import java.time.LocalDateTime

object LocalDateTimeX {
    infix fun LocalDateTime.isSameDayAs(otherDate: LocalDateTime) = dayOfYear == otherDate.dayOfYear
}