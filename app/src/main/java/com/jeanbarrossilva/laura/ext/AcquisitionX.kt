package com.jeanbarrossilva.laura.ext

import com.jeanbarrossilva.laura.foundation.Acquisition
import java.text.DecimalFormat

object AcquisitionX {
    val Acquisition.formattedValue: String get() = DecimalFormat.getCurrencyInstance().format(value)
}