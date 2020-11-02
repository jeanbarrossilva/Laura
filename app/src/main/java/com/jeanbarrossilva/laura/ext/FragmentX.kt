package com.jeanbarrossilva.laura.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow

object FragmentX {
    fun Fragment.reload() = parentFragmentManager.commitNow { detach(this@reload).attach(this@reload) }
}