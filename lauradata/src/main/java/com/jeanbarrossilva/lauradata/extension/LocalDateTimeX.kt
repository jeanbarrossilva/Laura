package com.jeanbarrossilva.lauradata.extension

import com.jeanbarrossilva.lauradata.extension.NumberX.withDoubleDigit
import com.jeanbarrossilva.lauradata.extension.StringX.capitalized
import com.jeanbarrossilva.lauradata.extension.StringX.lowerCased
import java.time.LocalDateTime

object LocalDateTimeX {
    val LocalDateTime.formattedExternally get() = "${month.name.lowerCased.capitalized} $dayOfMonth, $year"

    val LocalDateTime.formatted
        get() = "$year-${monthValue.withDoubleDigit}-${dayOfMonth.withDoubleDigit} ${hour.withDoubleDigit}:${minute.withDoubleDigit}"
}