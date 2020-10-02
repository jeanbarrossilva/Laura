package com.jeanbarrossilva.laura.ui.viewmodel

import android.view.View
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.jeanbarrossilva.laura.ui.component.IndicatorLayout
import com.jeanbarrossilva.laura.ui.adapter.OnboardingAdapter
import com.jeanbarrossilva.laura.ui.OnboardingSalaryFragment
import com.jeanbarrossilva.laura.ui.OnboardingFragment

class OnboardingViewModel(private val fragment: OnboardingFragment, @IdRes private val pagerId: Int) : ViewModel() {
    private val pager = fragment.view?.findViewById<ViewPager2>(pagerId)
    private val presentationFragments = listOf(OnboardingSalaryFragment())

    fun showFragments() {
        pager?.adapter = OnboardingAdapter(fragment, presentationFragments)
    }

    fun highlightIndicatorOf(indicatorLayout: IndicatorLayout) {
        pager?.addOnAttachStateChangeListener(object: View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(view: View?) {
                val presentationFragmentIndex = presentationFragments.map { fragment -> fragment.view }.indexOf(view)
                indicatorLayout.highlightIndicatorAt(presentationFragmentIndex)
            }

            override fun onViewDetachedFromWindow(view: View?) {
            }
        })
    }
}