package com.jeanbarrossilva.laurafoundation.ext

import com.jeanbarrossilva.laurafoundation.Acquisition
import java.text.DecimalFormat

object AcquisitionX {
    val Acquisition.formattedValue: String get() = DecimalFormat.getCurrencyInstance().format(value)
}