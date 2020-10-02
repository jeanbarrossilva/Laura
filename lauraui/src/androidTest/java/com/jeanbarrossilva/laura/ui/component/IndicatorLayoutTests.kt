package com.jeanbarrossilva.laura.ui.component

import android.view.View
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import kotlin.test.assertFailsWith

class IndicatorLayoutTests {
    private val context = InstrumentationRegistry.getInstrumentation().context
    private val indicatorLayout = IndicatorLayout(context)

    @Test
    fun addNonIndicatorView_throwsException() {
        val nonIndicatorView = View(InstrumentationRegistry.getInstrumentation().context)
        assertFailsWith<IllegalStateException> { indicatorLayout.addView(nonIndicatorView) }
    }
}