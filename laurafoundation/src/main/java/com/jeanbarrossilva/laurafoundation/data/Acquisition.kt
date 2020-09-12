package com.jeanbarrossilva.laurafoundation.data

import com.jeanbarrossilva.laurafoundation.data.AcquisitionCategory.GeneralAcquisition
import java.util.*

data class Acquisition(val category: AcquisitionCategory = GeneralAcquisition, val name: String, var currency: Currency, var value: Number)