package com.jeanbarrossilva.laurafoundation.ext

import java.time.LocalDateTime

object StringX {
    val String.asLocalDateTime: LocalDateTime?
        get() {
            return if (length == 16) {
                val (day, month, year) = Triple(substring(0..1).toInt(), substring(3..4).toInt(), substring(6..9).toInt())
                val (hour, minute) = substring(12..13).toInt() to substring(15..16).toInt()

                LocalDateTime.of(year, month, day, hour, minute)
            } else
                null
        }
}