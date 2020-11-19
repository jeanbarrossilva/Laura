package com.jeanbarrossilva.laura.ui.listener

import com.jeanbarrossilva.laura.data.BalanceInfluence

interface BalanceInfluenceSelectionListener {
    fun onBeginWith(influences: List<BalanceInfluence>)

    fun onEnd()
}