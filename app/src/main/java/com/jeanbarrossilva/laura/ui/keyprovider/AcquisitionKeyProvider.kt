package com.jeanbarrossilva.laura.ui.keyprovider

import androidx.recyclerview.selection.ItemKeyProvider
import com.jeanbarrossilva.laurafoundation.data.Acquisition

class AcquisitionKeyProvider(private val acquisitions: List<Acquisition>, scope: Int) : ItemKeyProvider<Acquisition>(scope) {
    override fun getKey(position: Int) = acquisitions[position]

    override fun getPosition(key: Acquisition) = acquisitions.indexOf(key)
}