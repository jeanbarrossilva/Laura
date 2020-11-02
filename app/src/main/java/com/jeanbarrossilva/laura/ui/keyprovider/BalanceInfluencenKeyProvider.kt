package com.jeanbarrossilva.laura.ui.keyprovider

import androidx.recyclerview.selection.ItemKeyProvider
import com.jeanbarrossilva.laurafoundation.data.BalanceInfluence

class BalanceInfluencenKeyProvider(private val influences: List<BalanceInfluence>, scope: Int) : ItemKeyProvider<Long>(scope) {
    override fun getKey(position: Int) = influences[position].id

    override fun getPosition(key: Long) = influences.find { acquisition -> key == acquisition.id }.let { influences.indexOf(it) }
}