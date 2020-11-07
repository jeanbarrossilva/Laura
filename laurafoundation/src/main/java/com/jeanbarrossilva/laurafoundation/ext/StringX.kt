package com.jeanbarrossilva.laurafoundation.ext

import java.time.LocalDateTime
import java.util.Locale

object StringX {
    val String.capitalized get() = capitalize(Locale.ROOT)
    val String.lowerCased get() = toLowerCase(Locale.ROOT)

    fun String.toLocalDateTime(): LocalDateTime? {
        return if (length == 16) {
            val (year, month, day) = Triple(substring(0..3).toInt(), substring(5..6).toInt(), substring(8..9).toInt())
            val (hour, minute) = substring(11..12).toInt() to substring(14..15).toInt()

            LocalDateTime.of(year, month, day, hour, minute)
        } else
            null
    }
}