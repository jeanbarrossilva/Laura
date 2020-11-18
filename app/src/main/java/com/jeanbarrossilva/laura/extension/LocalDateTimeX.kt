package com.jeanbarrossilva.laura.extension

import com.jeanbarrossilva.laura.extension.NumberX.withDoubleDigit
import com.jeanbarrossilva.laura.extension.StringX.capitalized
import com.jeanbarrossilva.laura.extension.StringX.lowerCased
import java.time.LocalDateTime

object LocalDateTimeX {
    val LocalDateTime.formattedExternally get() = "${month.name.lowerCased.capitalized} $dayOfMonth, $year"

    val LocalDateTime.formatted
        get() = "$year-${monthValue.withDoubleDigit}-${dayOfMonth.withDoubleDigit} ${hour.withDoubleDigit}:${minute.withDoubleDigit}"
}