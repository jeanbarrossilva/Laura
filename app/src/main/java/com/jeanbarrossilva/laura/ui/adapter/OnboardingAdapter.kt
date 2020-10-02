package com.jeanbarrossilva.laura.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jeanbarrossilva.laura.ui.OnboardingFragment

class OnboardingAdapter(fragment: OnboardingFragment, private val children: List<Fragment>) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = children.size

    override fun createFragment(position: Int) = children[position]
}