package com.jeanbarrossilva.laurafoundation.ext

import com.jeanbarrossilva.laurafoundation.ext.NumberX.withDoubleDigit
import com.jeanbarrossilva.laurafoundation.ext.StringX.capitalized
import com.jeanbarrossilva.laurafoundation.ext.StringX.lowerCased
import java.time.LocalDateTime

object LocalDateTimeX {
    val LocalDateTime.formattedExternally get() = "${month.name.lowerCased.capitalized} $dayOfMonth, $year"

    val LocalDateTime.formatted
        get() = "$year-${monthValue.withDoubleDigit}-${dayOfMonth.withDoubleDigit} ${hour.withDoubleDigit}:${minute.withDoubleDigit}"
}