package com.jeanbarrossilva.laura.foundation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jeanbarrossilva.laura.R
import java.time.LocalDateTime

sealed class AcquisitionCategory(@StringRes val name: Int, @DrawableRes val icon: Int) {
    object GeneralAcquisition : AcquisitionCategory(R.string.general, R.drawable.ic_question)

    data class FlightTicket(val takeOff: LocalDateTime, val landing: LocalDateTime)
        : AcquisitionCategory(R.string.flight_ticket, R.drawable.ic_local_airport) {
        val landingTime = "${landing.hour}:${landing.minute}"
        val takeOffTime = "${takeOff.hour}:${takeOff.minute}"
    }
}