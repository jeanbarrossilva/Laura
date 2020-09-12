package com.jeanbarrossilva.laurafoundation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.time.LocalDateTime

sealed class AcquisitionCategory(@StringRes val name: Int, @DrawableRes val icon: Int) {
    object GeneralAcquisition : AcquisitionCategory(R.string.acquisition_category_general, R.drawable.ic_question)

    data class FlightTicket(
        val takeOff: LocalDateTime = LocalDateTime.now(),
        val landing: LocalDateTime = LocalDateTime.from(takeOff).plusDays(1)
    )
        : AcquisitionCategory(R.string.acquisition_category_flight_ticket, R.drawable.ic_local_airport) {
        val landingTime = "${landing.hour}:${landing.minute}"
        val takeOffTime = "${takeOff.hour}:${takeOff.minute}"
    }
}