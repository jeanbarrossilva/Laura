package com.jeanbarrossilva.laurafoundation

import com.jeanbarrossilva.laurafoundation.AcquisitionCategory.GeneralAcquisition
import java.util.*

data class Acquisition(val category: AcquisitionCategory = GeneralAcquisition, val name: String, var currency: Currency, var value: Number)