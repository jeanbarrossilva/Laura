package com.jeanbarrossilva.laurafoundation.data

import android.location.Location
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jeanbarrossilva.laurafoundation.R
import java.time.LocalDateTime

sealed class AcquisitionCategory(@StringRes val name: Int, @DrawableRes val icon: Int) {
    object GeneralAcquisition : AcquisitionCategory(R.string.acquisition_category_general, R.drawable.ic_question)

    data class FlightTicket(
        val location: Pair<Location?, Location?> = null to null,
        val time: Pair<LocalDateTime, LocalDateTime> = LocalDateTime.now().let { now -> now to LocalDateTime.from(now).plusDays(1) }
    ) : AcquisitionCategory(R.string.acquisition_category_flight_ticket, R.drawable.ic_local_airport) {
    }
}