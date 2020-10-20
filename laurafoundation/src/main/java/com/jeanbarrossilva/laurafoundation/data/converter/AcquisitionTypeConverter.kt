package com.jeanbarrossilva.laurafoundation.data.converter

import com.jeanbarrossilva.laurafoundation.data.Acquisition
import com.jeanbarrossilva.laurafoundation.data.AcquisitionCategory

object AcquisitionTypeConverter {
    fun acquisitionToMap(acquisition: Acquisition?): Map<String, Any>? {
        return acquisition?.let {
            mapOf(
                "category" to AcquisitionCategory::class.sealedSubclasses.indexOf(acquisition.category::class)
            )
        }
    }

    fun mapToAcquisition(map: Map<String, Any>?) {

    }
}