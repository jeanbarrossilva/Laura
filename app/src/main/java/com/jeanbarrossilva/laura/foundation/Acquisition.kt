package com.jeanbarrossilva.laura.foundation

import android.icu.util.Currency
import com.jeanbarrossilva.laura.foundation.AcquisitionCategory.GeneralAcquisition

data class Acquisition(val category: AcquisitionCategory = GeneralAcquisition, val name: String, var currency: Currency, var value: Number)