package com.jeanbarrossilva.laura.ui.manager

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class LauraLinearLayoutManager(context: Context) : LinearLayoutManager(context) {
    override fun canScrollVertically() = false
}